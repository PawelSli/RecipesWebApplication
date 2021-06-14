import React, {Component} from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import App from "../App";
import DishService from "../services/dish.service"

class Dish extends Component{



    constructor(props) {
        super(props);
        this.convertValueToTimeUnit = this.convertValueToTimeUnit.bind(this);

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

    convertValueToTimeUnit(value){
        console.log(value)
        switch(value){
            case '1': return "minutes";
            case '2': return "hourse";
            case '3': return  "days";
        }

    }


    render() {
        const tempIngredients = [];
        const tempSteps = [];
        for(let i=0;i<this.state.steps.length;i++){

            tempSteps.push(
                <div >
                    <h5 className="display-6 text-danger font-weight-bold ">Step {i+1}</h5>
                    <p className="lead text-justify ">{this.state.steps[i]}</p>
                </div>
            )
        }
        for(let i=0;i<this.state.ingredients.length;i++){

            tempIngredients.push(
                <div>
                    <h6>{this.state.ingredients[i]} - {this.state.ingredientsQuantities[i]} {this.state.ingredientsUnits[i]}</h6>
                    <hr className="my-6"/>
                </div>
            )
        }





        return (
            <div>
                <div className="container-fluid col-12 my-dish">
                    <div className="row">
                        <div className="col-12 col-lg-7 mt-2">
                            <img className="d-block w-100 image-class"  src={process.env.PUBLIC_URL + `/${this.state.image}`}/>
                        </div>
                        <div className="col-12 col-lg-5 jumbotron jumbotron-fluid  bg-light text-dark pt-0">
                            <div className="container">
                                <h1 className="display-4">{this.state.dishTitle}</h1>
                                <p className="lead">{this.state.dishDesc}</p>
                                <hr className="my-4"/>
                                <h4>Preparation time : {this.state.preparationTimeQuantity} {this.convertValueToTimeUnit(this.state.preparationTimeUnit)}</h4>
                                <hr className="my-4"/>
                                <h4>Number of person : {this.state.numberOfPeople}</h4>
                                <hr className="my-4"/>
                                <h4>Difficulty : {this.state.difficulty}</h4>
                                <hr className="my-4"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div className="container-fluid col-12 pt-0 mt-0">
                    <div className="row">
                        <div className="col-12  col-lg-7 jumbotron jumbotron-fluid  bg-light text-dark pt-0 mt-0 pl-3">
                            {tempSteps}
                        </div>
                        <div className="col-12 col-lg-5 jumbotron jumbotron-fluid  bg-light text-dark pt-0 mt-0 text-center">
                            <h1 className="display-5 text-center">Ingredients</h1>
                            {tempIngredients}
                        </div>
                    </div>
                </div>
            </div>
    );
    }
}

export default Dish;