import React, {Component} from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import App from "../App";
import DishService from "../services/dish.service";
import AuthService from "../services/auth.service";



class AddDish extends Component{
    constructor(props) {
        super(props);
        this.isLoggedIn=AuthService.isLogged();

        this.state = {
            content: ""
        };
    }

    componentDidMount() {
        DishService.getAddDishPage().then(
            response => {
                this.setState({
                    content: response.data
                });
            },
            error => {
                this.setState({
                    content:
                        (error.response &&
                            error.response.data &&
                            error.response.data.message) ||
                        error.message ||
                        error.toString()
                });
            });
    }

    render() {
        return (
            <div
                className="container col-12 bg-light text-capitalize  d-flex flex-column  justify-content-center mt-5 ">
                <div className="row justify-content-center ">
                    <div className="col-6 align-items-center">
                        <h1>Add dish</h1>
                        <form>
                            <div className="mb-3">
                                <label htmlFor="dishNameInput" className="form-label">Dish name</label>
                                <input type="text" className="form-control" id="dishNameInput"
                                       aria-describedby="usernameHelp"></input>
                            </div>
                            <div className="mb-3">
                                <label htmlFor="dishDescription" className="form-label">Description</label>
                                <textarea className="form-control" id="dishDescription" rows="3"></textarea>
                            </div>
                            <div className="mb-3">
                                <label className="form-label">Preparation time</label>
                                <div className="row">
                                    <div className="col-7">
                                        <input type="number" className="form-control" min="1" max="1000"></input>
                                    </div>
                                    <div className="col-5">
                                        <select className="custom-select">
                                            <option value="1">minutes</option>
                                            <option value="2">hours</option>
                                            <option value="3">days</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div className="mb-3">
                                <label className="form-label">For how many people will this dish be?</label>
                                <input type="number" className="form-control" min="1" max="12"></input>
                            </div>
                            <div className="mb-3">
                                <label className="form-label">Define the number of components</label>
                                <input id="generateIngredientsInput" type="number" className="form-control" min="1"
                                       max="30" placeholder="Choose the number of ingredients for your dish:"></input>
                            </div>
                            <button id="generateIngredientsButton" type="button"
                                    className="btn btn-primary mb-4">Generate ingredients list
                            </button>

                            <div id="ingredients">

                            </div>

                            <div className="mb-3">
                                <label className="form-label">Define the number of steps</label>
                                <input id="generateStepsInput" type="number" className="form-control" min="1" max="30"
                                       placeholder="Choose the number of steps for your dish:"></input>
                            </div>
                            <button id="generateStepsButton" type="button" className="btn btn-primary mb-4">Generate
                                steps list
                            </button>

                            <div id="steps">

                            </div>

                            <button type="submit" className="btn btn-primary mb-2">Add dish</button>
                        </form>
                    </div>
                </div>
            </div>
        );
    }
}



export default AddDish;