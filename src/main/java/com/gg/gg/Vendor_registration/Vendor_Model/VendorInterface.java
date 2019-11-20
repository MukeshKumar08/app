package com.gg.gg.Vendor_registration.Vendor_Model;


import com.gg.gg.Vendor_registration.Vendor_Data.Vendor;
import com.gg.gg.Vendor_registration.Vendor_Data.VendorData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface VendorInterface {


    @POST("vendor")
    Call<VendorData> sendVendor(@Body Vendor vendor);

}

//

//    Call<Vendor> sendVendor(@Body VendorResponse vendorResponse);

//    Call<Vendor> sendVendor(String name, String city, String country, String state, String pinCode, String address, String email, String password, String latitudee, String longitudee);