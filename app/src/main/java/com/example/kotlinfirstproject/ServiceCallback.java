package com.example.kotlinfirstproject;

import android.util.Log;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public abstract class ServiceCallback<T> implements Callback<T> {
    private static final String TAG = "ServiceCallback";

    /**
     * Invoked for a received HTTP response.
     * <p/>
     * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
     * Call {@link Response#isSuccessful()} to determine if the response indicates success.
     *
     * @param call
     * @param response
     */

    @Override
    public void onResponse(Call<T> call, Response<T> response) {


        String str = new Gson().toJson(response.body());


        if (response.isSuccessful()) {
            onSuccess(response.body());

        } else {

            try {
                String errorJson = response.errorBody().string();

                Log.e("df", "Errorrrr : " + errorJson);

                ServiceError error = new Gson().fromJson(errorJson.trim(), ServiceError.class);
                error.setStatusCode(response.code());

                onFail(error);

            } catch (Exception e) {

                onFail(ServiceError.UNKNOWN);

            }
        }
    }

    /**
     * Invoked when a network exception occurred talking to the server or when an unexpected
     * exception occurred creating the request or processing the response.
     *
     * @param call
     * @param t
     */
    @Override
    public void onFailure(Call<T> call, Throwable t) {
        onFail(ServiceError.from(t));
        t.printStackTrace();
        Log.e("Fail", "Faillllllll " + t.toString());
    }

    /**
     * This is called when the status code is not in the 200s
     */
    public abstract void onFail(ServiceError error);

    /**
     * This is called when the status code is in the 200s
     *
     * @param response
     */
    public abstract void onSuccess(T response);
}
