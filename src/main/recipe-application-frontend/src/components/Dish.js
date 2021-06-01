import React, {Component} from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import App from "../App";
import DishService from "../services/dish.service"

class Dish extends Component{



    constructor(props) {
        super(props);
        const  PATH_URL = '../../../resources/static/images/';

        this.state = {
            dishTitle: null,
            dishDesc: null,
            preparationTimeQuantity: 0,
            preparationTimeUnit: null,
            numberOfPeople: null,
            difficulty: null,
            steps: [],
            ingredients: [],
            ingredientsUnits: [],
            ingredientsQuantities: [],
            image: null
        };

        DishService.getSpecificRecipe(window.location.href.split('/')[4]).then(
            response => {
                this.setState({
                    dishTitle: response.data.dishName,
                    dishDesc: response.data.dishDesc,
                    preparationTimeQuantity: response.data.preparationTimeQuantity,
                    preparationTimeUnit: response.data.preparationTimeUnit,
                    numberOfPeople: response.data.numberOfPeople,
                    difficulty: response.data.difficulty,
                    steps: response.data.steps,
                    ingredients: response.data.ingredients,
                    ingredientsUnits: response.data.ingredientsUnits,
                    ingredientsQuantities: response.data.ingredientsQuantities,
                    image: response.data.image
                });
                console.log(response.data)
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
        console.log(this.state.dishTitle);
        return (
            <div>
                <div className="container-fluid col-12 my-dish">
                    <div className="row">
                        <div className="col-7 mt-2">
                            <img className="d-block w-100 image-class"  src={process.env.PUBLIC_URL + `/${this.state.image}`}/>
                        </div>
                        <div className="col-5 jumbotron jumbotron-fluid  bg-light text-dark pt-0">
                            <div className="container">
                                <h1 className="display-4">{this.state.dishTitle}</h1>
                                <p className="lead">{this.state.dishDesc}</p>
                                <hr className="my-4"/>
                                <h4>Preparation time : {this.state.preparationTimeQuantity} {this.state.preparationTimeUnit}</h4>
                                <hr className="my-4"/>
                                <h4>Number of person : X</h4>
                                <hr className="my-4"/>
                                <h4>Difficulty : X</h4>
                                <hr className="my-4"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div className="container-fluid col-12 pt-0 mt-0">
                    <div className="row">
                        <div className="col-7 jumbotron jumbotron-fluid  bg-light text-dark pt-0 mt-0 pl-3">
                            <h1 className="display-6">Step 1</h1>
                            <p className="lead">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean fringilla ligula
                                a neque blandit auctor. Nulla viverra felis varius scelerisque facilisis. Mauris fermentum
                                vulputate purus ac malesuada. Aliquam aliquam mi vel tempor dictum. Curabitur et sapien
                                dignissim, lacinia eros non, pharetra diam.</p>
                            <h1 className="display-6">Step 2</h1>
                            <p className="lead">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean fringilla ligula
                                a neque blandit auctor. Nulla viverra felis varius scelerisque facilisis. Mauris fermentum
                                vulputate purus ac malesuada. Aliquam aliquam mi vel tempor dictum. Curabitur et sapien
                                dignissim, lacinia eros non, pharetra diam.</p>
                            <h1 className="display-6">Step 3</h1>
                            <p className="lead">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean fringilla ligula
                                a neque blandit auctor. Nulla viverra felis varius scelerisque facilisis. Mauris fermentum
                                vulputate purus ac malesuada. Aliquam aliquam mi vel tempor dictum. Curabitur et sapien
                                dignissim, lacinia eros non, pharetra diam.</p>
                            <h1 className="display-6">Step 4</h1>
                            <p className="lead">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean fringilla ligula
                                a neque blandit auctor. Nulla viverra felis varius scelerisque facilisis. Mauris fermentum
                                vulputate purus ac malesuada. Aliquam aliquam mi vel tempor dictum. Curabitur et sapien
                                dignissim, lacinia eros non, pharetra diam.</p>
                            <h1 className="display-6">Step 5</h1>
                            <p className="lead">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean fringilla ligula
                                a neque blandit auctor. Nulla viverra felis varius scelerisque facilisis. Mauris fermentum
                                vulputate purus ac malesuada. Aliquam aliquam mi vel tempor dictum. Curabitur et sapien
                                dignissim, lacinia eros non, pharetra diam.</p>
                            <h1 className="display-6">Step 6</h1>
                            <p className="lead">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean fringilla ligula
                                a neque blandit auctor. Nulla viverra felis varius scelerisque facilisis. Mauris fermentum
                                vulputate purus ac malesuada. Aliquam aliquam mi vel tempor dictum. Curabitur et sapien
                                dignissim, lacinia eros non, pharetra diam.</p>
                        </div>
                        <div className="col-5 jumbotron jumbotron-fluid  bg-light text-dark pt-0 mt-0 text-center">
                            <h1 className="display-5 text-center">Ingredients</h1>
                            <h6>Ingredient 1</h6>
                            <hr className="my-6"></hr>
                            <h6>Ingredient 2</h6>
                            <hr className="my-6"></hr>
                            <h6>Ingredient 3</h6>
                            <hr className="my-6"></hr>
                            <h6>Ingredient 4</h6>
                            <hr className="my-6"></hr>
                            <h6>Ingredient 5</h6>
                            <hr className="my-6"></hr>
                            <h6>Ingredient 6</h6>
                            <hr className="my-6"></hr>
                            <h6>Ingredient 7</h6>
                            <hr className="my-6"></hr>
                            <h6>Ingredient 8</h6>
                            <hr className="my-6"></hr>
                        </div>
                    </div>
                </div>
            </div>
    );
    }
}

export default Dish;