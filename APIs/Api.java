package com.example.verses;

import com.example.verses.Verses.Verse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/* Interface to defines requests & their EndPoints*/
/* It manage Api usage*/
public interface Api {

    String BASE_URL="EnterBaseUrlHere"; /* Api doc: BaseURL used in every Api request */

    /* GET request (rootThatWillBeAddedToBaseURL) */
    /* It returns with JSON array of Hero; so we stores it in List<Hero> */
    @GET("appendedToBaseUrl")
    Call<Verse> getConstantValue();

    @GET("{variableAppendedToBaseUrl}")
    Call<Verse> getDynamicValue(@Path("variableAppendedToBaseUrl") int variableAppendedToBaseUrl);

}
