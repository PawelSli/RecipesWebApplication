import axios from "axios";
import authHeader from "./auth-header";
import http from "../http-common";
const API_URL = "http://localhost:8080/";

class DishService{

    getMainPage(){
        return axios.get(API_URL);
    }

    getSpecificRecipe(){
        return axios.get(API_URL+"/recipe/${id}");
    }


    getAddDishPage(){
        return axios.get(API_URL+"addDish",{headers: authHeader()})
    }

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

export default new DishService();