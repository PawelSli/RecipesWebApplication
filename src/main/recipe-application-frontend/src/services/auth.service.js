import axios from "axios";
import authHeader from "./auth-header";

const API_URL = "http://localhost:8080/api/auth/";

class AuthService {

    login(email, password) {
        return axios.post(API_URL + "signin", {email, password}).then(response => {
            if (response.data.accessToken) {
                localStorage.setItem("user", JSON.stringify(response.data));
            }
            return response.data;
        });
    }

    isLogged() {
        const exist = localStorage.getItem("user");
        return !!exist;
    }

    logout() {
        localStorage.removeItem("user");
    }

    register(username, email, password) {
        return axios.post(API_URL + "signup", {username, email, password});
    }

    getCurrentUser() {
        console.log(localStorage.getItem("user"));
        return JSON.parse(localStorage.getItem("user"));
    }

    getAllUsers(){
        return axios.get(API_URL + "users",{
            headers:{
                Authorization: 'Bearer ' + JSON.parse(localStorage.getItem("user")).accessToken,
                'Access-Control-Allow-Origin': true
            },
            mode : 'cors'
        })
    }

    deleteUser(email){
        let config ={
            params: {
                email: email
            },
            headers: {
                Authorization: 'Bearer ' + JSON.parse(localStorage.getItem("user")).accessToken,
                'Access-Control-Allow-Origin': true
            },
            mode : 'cors',
        };
        return axios.delete(API_URL + "users",config);
    }

}

export default new AuthService();