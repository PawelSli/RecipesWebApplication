import axios from "axios";
import authHeader from "./auth-header";
import http from "../http-common";
const API_URL = "http://localhost:8080/";

class DishService{

    getMainPage(){
        return axios.get(API_URL);
    }

    getSpecificRecipe(index){
        return axios.get(API_URL+`recipe/${index}`,{
            headers:{
                'Access-Control-Allow-Origin': true
            },
            mode : 'cors'
        });
    }

    searchDishes(value){
        let config ={
            params: {
                query: value
            },
            headers: {
                'Access-Control-Allow-Origin': true
            },
            mode : 'cors',
        };

        return axios.get(API_URL+"search",config);
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

    getUserDishes(){
        return axios.get(API_URL+`profile`,{
            headers:{
                Authorization: 'Bearer ' + JSON.parse(localStorage.getItem("user")).accessToken,
                'Access-Control-Allow-Origin': true
            },
            mode : 'cors'
        });
    }
}

export default new DishService();