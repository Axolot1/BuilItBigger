package com.axolotl.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;

import java.util.concurrent.CountDownLatch;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    CountDownLatch mSignal;
    String resultString;

    public ApplicationTest() {
        super(Application.class);
    }

    @Override
    protected void setUp() throws Exception {
        mSignal = new CountDownLatch(1);
    }

    @Override
    protected void tearDown() throws Exception {
        mSignal.countDown();
    }

    public void testAsyncTask() throws InterruptedException {
        EndpointsAsyncTask task = new EndpointsAsyncTask();
        task.setListener(new EndpointsAsyncTask.EndPointTaskListener() {
            @Override
            public void onComplete(String result) {
                resultString = result;
                mSignal.countDown();
            }
        });
        task.execute();
        mSignal.await();
        assertNotNull(resultString);
        assertEquals("This is totally a funny joke", resultString);
    }
}