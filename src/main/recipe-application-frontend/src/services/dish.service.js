import axios from "axios";
import authHeader from "./auth-header";
const API_URL = "http://localhost:8080/";

class DishService{

    getMainPage(){
        return axios.get(API_URL);
    }

    getSpecificRecipe(){
        return axios.get(API_URL+"/recipe/${id}");
    }


    getAddDishPage(){
        console.log("Heeeee");
        return axios.get(API_URL+"addDish",{headers: authHeader()})

    }
}

export default new DishService();