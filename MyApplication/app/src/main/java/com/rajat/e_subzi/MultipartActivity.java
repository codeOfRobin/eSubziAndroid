//
//private static void uploadFile(File file1) {
//        // create upload service client
//        FileUploadService service =
//        ServiceGenerator.createService(FileUploadService.class);
//
//        // use the FileUtils to get the actual file by uri
//        File file = file1;
//
//        // create RequestBody instance from file
//        RequestBody requestFile =
//        RequestBody.create(MediaType.parse("multipart/form-data"), file);
//
//        // MultipartBody.Part is used to send also the actual file name
//        MultipartBody.Part body =
//        MultipartBody.Part.createFormData("picture", file.getName(), requestFile);
//
//        // add another part within the multipart request
//        String descriptionString = "hello, this is description speaking";
//        RequestBody description =
//        RequestBody.create(
//        MediaType.parse("multipart/form-data"), descriptionString);
//
//        // finally, execute the request
//        Call<ResponseBody> call = service.upload(description, body);
//        call.enqueue(new Callback<ResponseBody>() {
//@Override
//public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
//        Log.v("Upload", "success");
//        }
//
//@Override
//public void onFailure(Call<ResponseBody> call, Throwable t) {
//        Log.e("Upload error:", t.getMessage());
//        }
//        });
//        }

//compile files('libs/retrofit-2.0.1.jar')
//compile files('libs/okhttp-3.2.0.jar')
  //      compile 'com.squareup.retrofit2:converter-gson:2.0.0'