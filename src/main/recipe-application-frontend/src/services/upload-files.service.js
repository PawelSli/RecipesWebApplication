import axios from "axios";
import http from "../http-common"
import authHeader from "./auth-header";
const API_URL = "http://localhost:8080/";

class UploadFilesService{


    upload(file,dishName,dishDesc,preparationTimeQuantity, preparationTimeUnit,numberOfPeople,difficulty, steps,ingredients,ingredientsUnits,ingredientsQuantities){

        let formData = new FormData();

        formData.append("file",file);
        formData.set("dishName",dishName);
        formData.set("dishDesc",dishDesc);
        formData.set("preparationTimeQuantity",preparationTimeQuantity);
        formData.set("preparationTimeUnit",preparationTimeUnit);
        formData.set("numberOfPeople",numberOfPeople);
        formData.set("difficulty",difficulty);
        formData.set("steps",steps);
        formData.set("ingredients",ingredients);
        formData.set("ingredientsUnits",ingredientsUnits);
        formData.set("ingredientsQuantities",ingredientsQuantities);


        console.log(formData.get("steps"));
        console.log(formData.get("ingredients"));
        console.log(formData.get("ingredientsUnits"));
        console.log(formData.get("ingredientsQuantities"));

        return http.post("/addDish",formData,{
            headers:{

                "Content-Type": "multipart/form-data",
                Authorization: 'Bearer '+JSON.parse(localStorage.getItem("user")).accessToken,
                'Access-Control-Allow-Origin': true
        },
            mode : 'cors'
        }
        );
    }

    getFiles() {
        return http.get("/files");
    }

}

export default new UploadFilesService();