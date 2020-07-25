package com.integro.sjii.apis;

import com.integro.sjii.models.AlumniList;
import com.integro.sjii.models.AnnouncementList;
import com.integro.sjii.models.FacilitiesList;
import com.integro.sjii.models.FacilityImagesList;
import com.integro.sjii.models.FacultyList;
import com.integro.sjii.models.Institution;
import com.integro.sjii.models.InstitutionList;
import com.integro.sjii.models.ManagementList;
import com.integro.sjii.models.NewsImagesList;
import com.integro.sjii.models.NewsLetter;
import com.integro.sjii.models.NewsLetterList;
import com.integro.sjii.models.NewsList;
import com.integro.sjii.models.NotificationsList;
import com.integro.sjii.models.PrincipalmsgList;
import com.integro.sjii.models.SjiiPTAList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiServices {

        @POST("sjii_app/sjii_news.php")
        Call<NewsList> getNewsList();

        @FormUrlEncoded
        @POST("sjii_app/sjii_newsimages.php")
        Call<NewsImagesList> getNewsImagesList(@Field("news_id")String update_at);

        @FormUrlEncoded
        @POST("sjii_app/sjii_pta.php")
        Call<NotificationsList> getNotifications(@Field("tag")String tag);

        @POST("sjii_app/sjii_pta1.php")
        Call<SjiiPTAList> getSjiiPTAList();

        @POST("/sjii_app/sjii_announcement.php")
        Call<AnnouncementList> getAnnouncementList();

        @POST("/sjii_app/sjii_faculty.php")
        Call<FacultyList> getFacultyList();

        @POST("/sjii_app/sjii_institution.php")
        Call<InstitutionList> getInstitutionsList();

        @FormUrlEncoded
        @POST("/sjii_app/sjii_newsletter.php")
        Call<NewsLetterList> getNewsLetterList(@Field("updated_at") String updated_at);

        @POST("/sjii_app/sjii_facilities.php")
        Call<FacilitiesList> getFacilitiesList();

        @POST("/sjii_app/sjii_alumni.php")
        Call<AlumniList> getAlumniList();

        @POST("sjii_app/sjii_management.php")
        Call<ManagementList> getManagementList();

        @FormUrlEncoded
        @POST("/sjii_app/sjii_facilitiesimg.php")
        Call<FacilityImagesList> getFacilityImagesList(@Field("f_id")String f_id);

        @FormUrlEncoded
        @POST("/sjii_app/sjii_principalmsg.php")
        Call<PrincipalmsgList> getPrincipalmsgList(@Field("tag")String tag);
}
