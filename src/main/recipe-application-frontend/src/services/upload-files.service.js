import http from "../http-common"

class UploadFilesService{
    upload(file){
        let formData = new FormData();
        formData.append("file",file);
        return http.post("/addDish",formData,{
            headers: {
                "Content-Type": "multipart/form-data",
            },
        })
    }
}