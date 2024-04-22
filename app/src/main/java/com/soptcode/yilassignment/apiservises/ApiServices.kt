package com.soptcode.yilassignment.apiservises

import com.soptcode.yilassignment.model.NameResponse
import com.soptcode.yilassignment.network.NetworkConstants
import io.reactivex.Observable
import retrofit2.http.GET


interface ApiServices {

    @GET(NetworkConstants.NAME_LIST)
    fun getContact(): Observable<NameResponse>


    /*  @POST(IntentConstant.SIGN_UP)
      fun signUp(
          @Body request:ResponseSignup

          ): Observable<SignUpResponse>



      @POST(IntentConstant.LOG_IN)
      fun login(
         @Body request:RequestLogin

      ): Observable<SignInResponse>



         @POST(IntentConstant.VERIFY_OTP)
         fun verifyotp(
            @Body request:RequestOtp

         ): Observable<VerifyOtpResponse>




      @POST(IntentConstant.OTP_RESEND)
      fun resentopt(
          @Body request:RequestResendOtp

          ): Observable<ResendotpResponse>








      @POST(IntentConstant.FORGOTE_PASSWORD)
      fun forgotpassword(

         @Body request: RequestForgotPssword

      ): Observable<ForgotPasswordResponse>


      @POST(IntentConstant.FORGOTE_PASSWORD_OTP)
      fun forgotpasswordotp(

          @Body request: RequestForgotPasswordOtp

      ): Observable<VerifyForgotPasswordOtpResponse>




      @POST(IntentConstant.RESET_PASSWORD)
      fun resetPassword(
          @Body request:RequestResetPassword

      ): Observable<ResetPasswordResponse>


      @Multipart
      @POST(IntentConstant.PROFILE_CREATION)
      fun profilecreate(
          @Header("Authorization") Authorization: String,
          @Part("first_name") first_name: RequestBody?,
          @Part("last_name") last_name: RequestBody?,
          @Part("mobile_number") mobile_number: RequestBody?,
          @Part("country_code") country_code: RequestBody?,
          @Part("gender") gender: RequestBody?,
          @Part("date_of_birth") date_of_birth: RequestBody?,
          @Part("allergic_to") allergic_to: RequestBody?,
          @Part profile_image:MultipartBody.Part?=null

      ): Observable<ProfileCreateResponse>




      @GET(IntentConstant.HOME_CUSINES_LIST)
      fun homecuisine(

      ): Observable<HomeCousinesResponse>

      @GET(IntentConstant.HOME_RESTAURANT_LIST)
      fun homerestaurantlist(

      ): Observable<RestaurantListResponse>




      @POST(IntentConstant.NEAR_BY_RESTAURANT)
      fun nearbyrestaurant(
          @Query ("page")page:Int,
          @Query ("limit")limit:Int,
          @Body request:RequestNearByRestaurant



      ): Observable<NearByRestaurantResponse>


      @GET(IntentConstant.SUGGESTION_SEARCH)
      fun suggestserch(

      ): Observable<SuggestionSearchResponse>
  */
/*

   @FormUrlEncoded
   @POST(IntentConstant.OTP_FORGOTE_PASSWORD)
   fun forgotPasswordOtpVerify(
       @Field("mobile_number") mobile_number: String,
       @Field("otp") otp: String

   ): Observable<ForgetPasswordOtpVerifyResposne>

   @FormUrlEncoded
   @POST(IntentConstant.RESET_PASSWORD)
   fun resetPassword(
       @Field("password") password: String,
       @Field("secret_key") secret_key: String

   ): Observable<ResetPasswordResponse>



   @FormUrlEncoded
   @POST(IntentConstant.CONTACT_LIST)
   fun contact(
       @Field("mobile_number") mobile_number: String,
       @Field("code") code: String

   ): Observable<contactModel>



   @GET("v1/current.json")
   fun weatherApi(
       @Query("key") key: String,
       @Query("q") q: String,
       @Query("aqi") aqi: String

   ): Observable<WeatherResponse>



   @GET(IntentConstant.GET_COUNTRY)
   fun getCountry(): Observable<GetCountryResponse>



   @GET(IntentConstant.GET_STATE)
   fun getState(
       @Query("id") id: Int
   ): Observable<GetStateResponse>




   @GET(IntentConstant.GET_CITY)
   fun getCity(
       @Query("id") id: Int

   ): Observable<GetCityResponse>



   @FormUrlEncoded
   @POST(IntentConstant.SAVE_COUNTRY)
   fun saveCountry(
       @Header("Authorization") Authorization: String,
       @Field("country") country: String,
       @Field("state") state: String,
       @Field("city") city: String
   ): Observable<SaveCountryCityResponse>

   @GET(IntentConstant.GET_SVAE_COUNTRY_LIST)
   fun getCountryList(
       @Header("Authorization") Authorization: String

   ):Observable<GetCountryListResponse>


   @FormUrlEncoded
   @POST(IntentConstant.DELETE_COUNTRY)
   fun deleteCountry(
       @Header("Authorization") Authorization: String,
       @Field("pk") pk: Int

   ): Observable<DeleteCountryResponse>


   @FormUrlEncoded
   @POST(IntentConstant.APPLE_NEWS)
   fun appleNew(
       @Field("keyword") keyword: String
   ): Observable<AppleBitcoinNewsResponse>

   @FormUrlEncoded
   @POST(IntentConstant.TESLA_NEWS)
   fun teslaNews(
       @Field("keyword") keyword: String
   ): Observable<TeslaResponse>

   @FormUrlEncoded
   @POST(IntentConstant.TEECHCRUNCH_NEWS)
   fun techcrunch(
       @Field("keyword") keyword: String
   ): Observable<TechCrunchResponse>


   @FormUrlEncoded
   @POST(IntentConstant.THEWALL_NEWS)
   fun thewallstreet(
       @Field("keyword") keyword: String
   ): Observable<TheWallStreetResponse>

   @FormUrlEncoded
   @POST(IntentConstant.UAE_NEWS)
   fun uaenews(
       @Field("keyword") keyword: String
   ): Observable<UaeResponse>



   @GET(IntentConstant.PRIFIELD_VIEW)
   fun prifieldview(
       @Header("Authorization") Authorization: String

   ): Observable<PrifieldViewNameResponse>



   @FormUrlEncoded
   @POST(IntentConstant.SAVE_NEWS_USER)
   fun saveUserNews(
       @Header("Authorization") Authorization: String,
       @Field("name") name: String,
       @Field("service_provider") service_provider: String,
       @Field("description") description: String

   ): Observable<UserSendResponse>



   @GET(IntentConstant.USER_REQUEST_NEWS)
   fun getuserrequestNews(
       @Header("Authorization") Authorization: String

   ): Observable<UserRequestNewsResponse>


   @FormUrlEncoded
   @POST(IntentConstant.COMMIT_FEEDBACK)
   fun commitFeedback(
       @Header("Authorization") Authorization: String,
       @Field("feedback") feedback: String,
       @Field("id") id: Int
   ): Observable<CommitFeedbackResponse>


   @FormUrlEncoded
   @POST(IntentConstant.GET_COMMIT_NEW)
   fun getcommit(
       @Header("Authorization") Authorization: String,
       @Field("id") id: Int

   ): Observable<GetCommitNewResponse>


   @FormUrlEncoded
   @POST(IntentConstant.NEWS_LIKE)
   fun likeNew(
       @Header("Authorization") Authorization: String,
       @Field("id") id: Int

   ): Observable<LikeResponse>

*/

    /*

    @POST(IntentConstant.OTP_RESEND)
    fun resendOtp(
        @Header("Authorization") Authorization: String

    ): Observable<ResendResponse>

    @Multipart
    @POST(IntentConstant.PROFILE_IMAGE)
    fun profilephoto(
        @Header("Authorization") Authorization: String,
        @Part profile_pic: MultipartBody.Part? = null



    ): Observable<ProfilePhotoResponse>

    @FormUrlEncoded
    @POST(IntentConstant.FORGOTE_PASSWORD)
    fun forgetPasswordMobile(
        @Field("country_code") country_code: String,
        @Field("mobile_number") mobile_number: String
    ): Observable<ForgoteResponse>

    @FormUrlEncoded
    @POST(IntentConstant.FORGOTE_PASSWORD)
    fun forgetPasswordEmail(
        @Field("email") email: String
    ): Observable<ForgoteResponse>

    @FormUrlEncoded
    @POST(IntentConstant.RESET_PASSWORD)
    fun resetPassword(
        @Header("Authorization") Authorization: String,
        @Field("new_password") new_password: String,
        @Field("conf_password") conf_password: String
    ): Observable<ResetResponse>

    @GET(IntentConstant.HOME_LIST)
    fun homelist(
        @Header("Authorization") Authorization: String
    ): Observable<HomeResponse>

    @GET(IntentConstant.BrandAndModel)
    fun getBrandAndModel(
        @Header("Authorization") Authorization: String,
        @Path("subCatId") subCatId: String
    ): Observable<BrandsAndModelListResponse>

    @FormUrlEncoded
    @POST(IntentConstant.QUESTION_LIST)
    fun getQuestionList(
        @Field("category") category: Int,
        @Field("subcategory") subcategory: Int
    ): Observable<GetQuestionListResponse>

    @GET(IntentConstant.PRODUCT_LIST)
    fun getProduct(
        @Header("Authorization") Authorization: String
    ): Observable<ProductListResponse>

    @GET(IntentConstant.FULFILLED_BY_VERIFIED)
    fun getFullfilledBy(
        @Header("Authorization") Authorization: String
    ): Observable<ProductListResponse>

    @GET(IntentConstant.CASH_OFFER)
    fun getCashOffer(
        @Header("Authorization") Authorization: String
    ): Observable<ProductListResponse>

    @GET(IntentConstant.TRADE_IN)
    fun getTradeIn(
        @Header("Authorization") Authorization: String
    ): Observable<TraddInResponse>

    @Multipart
    @POST(IntentConstant.ADD_PRODUCT)
    fun addProduct(
        @Header("Authorization") Authorization: String,
        @Part("category") category: RequestBody,
        @Part("subcategory") subcategory: RequestBody,
        @Part("product_name") product_name: RequestBody,
        @Part product_image: ArrayList<MultipartBody.Part>? = null,
        @Part("price") price: RequestBody,
        @Part("brand") brand: RequestBody,
        @Part("brand_model") brand_model: RequestBody,
        @Part("product_desc") product_desc: RequestBody,
        @Part("is_verified") is_verified: RequestBody,
        @Part("details") details: RequestBody,
        @Part("product_type") product_type: RequestBody
    ): Observable<AddProductResponse>

    @Multipart
    @PUT(IntentConstant.UPDATE_PRODUCT)
    fun updateProduct(
        @Header("Authorization") Authorization: String,
        @Path("productId") productId: Int,
        @Part("category") category: RequestBody,
        @Part("subcategory") subcategory: RequestBody,
        @Part("product_name") product_name: RequestBody,
        @Part product_image: ArrayList<MultipartBody.Part>? = null,
        @Part("price") price: RequestBody,
        @Part("brand") brand: RequestBody,
        @Part("brand_model") brand_model: RequestBody,
        @Part("product_desc") product_desc: RequestBody,
        @Part("details") details: RequestBody
    ): Observable<AddProductResponse>

    @Multipart
    @POST(IntentConstant.UploadFile)
    fun uploadFile(
        @Part image: MultipartBody.Part? = null
    ): Observable<UploadFileResponse>

    @FormUrlEncoded
    @POST(IntentConstant.SOCIAL_LOGIN)
    fun socialLoginApi(
        @Field("full_name") full_name: String,
        @Field("email") email: String,

        @Field("device_token") device_token: String,
        @Field("device_type") device_type: String,
        @Field("social_id") social_id: String,
        @Field("account_type") account_type: String
    ): Observable<SocialLoginResponse>

    @GET(IntentConstant.PRODUCT_CATEGORY)
    fun getProductCategory(
        @Header("Authorization")Authorization:String,
        @Path("CatId") CatId: String
    ): Observable<ProductCategoryResponse>

    @FormUrlEncoded
    @POST(IntentConstant.PRODUCT_FILTER)
    fun filterApi(
        @Header("Authorization")Authorization:String,
        @Field("category") category: String,
        @Field("filter") filter: Int,
        @Field("subcategory") subcategory: String,
        @Field("brand") brand: String,
        @Field("min_price") min_price: String,
        @Field("max_price") max_price: String
    ): Observable<ProductFilterResponse>

    @FormUrlEncoded
    @POST(IntentConstant.ACCEPT_REJECT)
    fun acceptApi(
        @Header("Authorization") Authorization: String,
        @Field("status_type") status_type: String,
        @Field("quote_id") quote_id: Int
    ): Observable<AcceptResponse>

    @FormUrlEncoded
    @POST(IntentConstant.ACCEPT_REJECT)
    fun quoterejectApi(
        @Header("Authorization") Authorization: String,
        @Field("status_type") status_type: String,
        @Field("quote_id") quote_id: Int
    ): Observable<QuoteRejectedResponse>

    @FormUrlEncoded
    @POST(IntentConstant.SEARCH_PRODUCT)
    fun searchProduct(
        @Header("Authorization") Authorization: String,
        @Field("search") search: String
    ): Observable<SearchProductResponse>

   *//* @GET(IntentConstant.SEARCH_PRODUCT)
   fun searchProduct(
       @Header("Authorization") Authorization: String,
       @Query("search") search: String

   ): Observable<SearchProductResponse>
*//*
   @GET(IntentConstant.RECENT_SEARCH)
   fun recentSearchProduct(
       @Header("Authorization") Authorization: String
   ): Observable<RecentSearchResponse>

   @FormUrlEncoded
   @POST(IntentConstant.FAVORITE_SAVE)
   fun favoritesApi(
       @Header("Authorization") Authorization: String,
       @Field("product") product: Int

   ): Observable<FavoriteSaveResponse>

   @GET(IntentConstant.PRODUCT_DETAILS+"/{Id}")
   fun getproductdetails(
       @Header("Authorization") Authorization: String,
       @Path("Id") Id: Int
   ): Observable<Product_detailsResponse>

   @GET(IntentConstant.GET_FAVORITE)
   fun getFavorites(
       @Header("Authorization") Authorization: String

   ): Observable<GetFavoriteResponse>

   @GET(IntentConstant.GET_ADD_CARD)
   fun getAddCard(
       @Header("Authorization") Authorization: String

   ): Observable<GetAddToCardResponse>

   @FormUrlEncoded
   @POST(IntentConstant.SAVE_ADDRESS)
   fun saveAddressApi(
       @Header("Authorization") Authorization: String,
       @Field("name") name: String,
       @Field("contact") contact: String,
       @Field("country") country: String,
       @Field("city") city: String,
       @Field("zipcode") zipcode: String,
       @Field("address") address: String

   ): Observable<ResponseSaveAddress>

   @FormUrlEncoded
   @POST(IntentConstant.ADD_CARD)
   fun addCardApi(
       @Header("Authorization") Authorization: String,
       @Field("product") product: Int

   ): Observable<AddCardsResponse>

   @GET(IntentConstant.GET_ADD_ADDRESS)
   fun getAddAddress(
       @Header("Authorization") Authorization: String

   ): Observable<ResponseGetAddresses>

   @GET(IntentConstant.GET_COUNTRY)
   fun getCountry(): Observable<CountryResponse>

   @DELETE(IntentConstant.REMOVE_FROM_CART)
   fun removeFromCart(
       @Header("Authorization") Authorization: String,
       @Path("itemId") itemId: String
   ): Observable<ResponseRemoveFromCart>

   @FormUrlEncoded
   @POST(IntentConstant.GET_CHECKOUT_DETAIL)
   fun checkoutDetails(
       @Header("Authorization") Authorization: String,
       @Field("product_id") product_id: String
   ):Observable<ResponseCheckoutProduct>

   @GET(IntentConstant.ORDER_SUMMARY)
   fun orderSummary(
       @Header("Authorization") Authorization: String,
       @Path("itemId") itemId: String
   ):Observable<ResponseOrderSummary>

   @FormUrlEncoded
   @POST(IntentConstant.PLACE_ORDER)
   fun placeOrder(
       @Header("Authorization") Authorization: String,
       @Field("product_id") product_id: String,
       @Field("payment_method") payment_method: String,
       @Field("shipping_address") shipping_address: String
   ):Observable<ResponsePlaceOrder>

   @GET(IntentConstant.ORDER_STATUS)
   fun orderStatus(
       @Header("Authorization") Authorization: String,
       @Path("itemId") itemId: String
   ):Observable<ResponseOrderStatus>


   @GET(IntentConstant.GET_MY_ORDER)
   fun myorderOne(
       @Header("Authorization") Authorization: String

   ):Observable<MyOrderOneResponse>



   @GET(IntentConstant.GET_MY_ORDER_TWO)
   fun myordertwo(
       @Header("Authorization") Authorization: String

   ):Observable<MyOrderTwoResponse>


   @GET(IntentConstant.GET_VERIFY_CREADIT)
   fun getverifyCredite(
       @Header("Authorization") Authorization: String

   ):Observable<VerifyCrediteResponde>


   @GET(IntentConstant.PROFILE_DETAILS)
   fun getProfileDetails(
       @Header("Authorization") Authorization: String

   ):Observable<ProfileDetailsResponse>


   @Multipart
   @PUT(IntentConstant.EDITE_PROFILE)
   fun userEditProfileApi(
       @Header("Authorization") Authorization: String,
       @Part("full_name") full_name: RequestBody,
       @Part profile_pic: MultipartBody.Part? = null
   ): Observable<UpdateProfileResponse>


   @FormUrlEncoded
   @POST(IntentConstant.BANK_DETAILS)
   fun bankDetails(
       @Header("Authorization") Authorization: String,
       @Field("bank_name") bank_name: String,
       @Field("account_holder_name") account_holder_name: String,
       @Field("account_number") account_number: String,
       @Field("iban_code") iban_code: String
   ):Observable<BankDEtailsResponse>


   @DELETE(IntentConstant.REMOVE_MY_PRODUCT)
   fun productDelete(
       @Header("Authorization") Authorization: String,
       @Path("itemId") itemId: String
   ): Observable<MyProductDeleteResponse>






   @DELETE(IntentConstant.DELETE_ADDRESS)
   fun AddressDelete(
       @Header("Authorization") Authorization: String,
       @Path("itemId") itemId: String
   ): Observable<DeleteAddressResponse>





   @FormUrlEncoded
   @POST(IntentConstant.CANCLE_ORDER)
   fun cancleOrder(
       @Header("Authorization") Authorization: String,
       @Field("order_id") order_id: String,
       @Field("reason") reason: String,
       @Field("reason_text") reason_text: String
   ):Observable<OrderCancleResponse>


   @FormUrlEncoded
   @POST(IntentConstant.AFTER_PAYMENT)
   fun afterPayment(
       @Header("Authorization") Authorization: String,
       @Field("token_id") token_id: String,
       @Field("order_id") order_id: String
   ): Observable<AfterPaymentResponse>

   @Multipart
   @POST(IntentConstant.RAISE_TICKET)
   fun raiseTicketDetails(
       @Header("Authorization") Authorization: String,
       @Part("subject") subject :  RequestBody,
       @Part("description") description :  RequestBody,
       @Part images: ArrayList<MultipartBody.Part>? = null

       ): Observable<RaiseTicketResponse>


   @GET(IntentConstant.REFERRAL_CODE)
   fun getReferralCode(
       @Header("Authorization") Authorization: String

   ):Observable<ReferralCodeResponse>

   @GET(IntentConstant.SUPPORT_TICKET)
   fun getSupportTicketOne(
       @Header("Authorization") Authorization: String
   ):Observable<SupportTicketOneResponse>

   @GET(IntentConstant.SUPPORT_TICKET_TWO)
   fun getSupportTicketTwo(
       @Header("Authorization") Authorization: String
   ):Observable<SupportTicketTwoResponse>


   @FormUrlEncoded
   @POST(IntentConstant.CHANGE_PASSWORD)
   fun changePassword(
       @Header("Authorization") Authorization: String,
       @Field("old_password") old_password: String,
       @Field("new_password") new_password: String,
       @Field("conf_password") conf_password: String
   ): Observable<ChangePasswordResponse>


   @POST(IntentConstant.ACCOUNT_DELETE)
   fun accountDelete(
       @Header("Authorization") Authorization: String
   ): Observable<UserAccountDeleteResponse>

   @FormUrlEncoded
   @POST(IntentConstant.NOTIFICATION_ENABLE)
   fun notificationEnable(
       @Header("Authorization") Authorization: String,
       @Field("enabled") enabled: Int
   ): Observable<NotificationEnableResponse>


   @FormUrlEncoded
   @POST(IntentConstant.TWO_FACTOR_ENABLE)
   fun twoFactorEnable(
       @Header("Authorization") Authorization: String,
       @Field("enabled") enabled: Int
   ): Observable<TwoFactorEnableDisableResponse>


   @GET(IntentConstant.GET_NOTIFICATION)
   fun getNotification(
       @Header("Authorization") Authorization: String
   ):Observable<UserNotificationResponse>
*/

}

