import React, {Component} from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import App from "../App";
import DishService from "../services/dish.service";
import AuthService from "../services/auth.service";
import Ingredient from "./subcomponents/Ingredient";
import Step from "./subcomponents/Step";
import {Scope as arr} from "@babel/traverse";



export default class AddDish extends Component{
    constructor(props) {
        super(props);

        this.state = {
            ingredientUnitList: [],
            recipeDifficulties: [],
            totalSteps: 0,
            totalStepsInput: '',
            totalIngredients: 0,
            totalIngredientsInput: ''
        };

        DishService.getAddDishPage().then(
            response => {
                this.setState({
                    ingredientUnitList: response.data.ingredientUnitList,
                    recipeDifficulties: response.data.recipeDifficulties
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

    onChange = (event) => {
        this.setState({
            [event.target.name]: event.target.value
        })
    }

    addIngredients = ()=>{
        this.setState({
            totalIngredients: this.state.totalIngredientsInput
        })
    }

    addSteps = ()=>{
        this.setState({
            totalSteps: this.state.totalStepsInput
        })
    }


    componentDidMount() {

    }


    render() {

        const ingredients = [];
        const steps = [];
        for(let i=1;i<=this.state.totalSteps;i++){
            steps.push(
                <div className="mb-4 my-step-class">
                    <label className="form-label text-danger">Step nr {i}</label>
                    <textarea onChange={this.onChange} className="form-control" placeholder="Description - Step " rows="3"/>
                </div>
            )
        }
        for(let i=1;i<=this.state.totalIngredients;i++){
            ingredients.push(
                <div className="mb-4 my-ingredient-class">
                    <label className="form-label text-info">Ingredient nr {i}</label>
                    <input type="text" className="form-control" aria-describedby="usernameHelp"/>
                    <label className="form-label">Amount of the ingredient</label>
                    <div className="row">
                        <div className="col-7">
                            <input onChange={this.onChange} type="number" className="form-control" min="1" max="1000"/>
                        </div>
                        <div className="col-5">
                            {console.log(this.state.ingredientUnitList[0])}
                            <select className="custom-select">
                                {this.state.ingredientUnitList.map(item =>{
                                    return <option value={item.index}>{item}</option>
                                })};
                            </select>
                        </div>
                    </div>
                </div>
            )
        }




        return (
            <div
                className="container col-12 bg-light text-capitalize  d-flex flex-column  justify-content-center mt-5 ">
                <div className="row justify-content-center ">
                    <div className="col-6 align-items-center">
                        <h1>Add dish</h1>
                        <form>
                            <div className="mb-3">
                                <label htmlFor="dishNameInput" className="form-label">Dish name</label>
                                <input type="text" className="form-control" id="dishNameInput" aria-describedby="usernameHelp"/>
                            </div>
                            <div className="mb-3">
                                <label htmlFor="dishDescription" className="form-label">Description</label>
                                <textarea className="form-control" id="dishDescription" rows="3"/>
                            </div>
                            <div className="mb-3">
                                <label className="form-label">Preparation time</label>
                                <div className="row">
                                    <div className="col-7">
                                        <input type="number" className="form-control" min="1" max="1000"/>
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
                                <input type="number" className="form-control" min="1" max="12"/>
                            </div>
                            <div className="mb-3">
                                <label className="form-label">Define the number of components</label>
                                <input onChange={(e) => this.setState({ totalIngredientsInput: e.target.value})} value={this.state.totalIngredientsInput} id="generateIngredientsInput" type="number" className="form-control" min="1" max="30" placeholder="Choose the number of ingredients for your dish:"/>
                            </div>
                            <button onClick={this.addIngredients} type="button" className="btn btn-primary mb-4">
                                Generate ingredients list
                            </button>

                            <div id="ingredients">
                                {ingredients}
                            </div>

                            <div className="mb-3">
                                <label className="form-label">Define the number of steps</label>
                                <input onChange={(e) => this.setState({ totalSteps: e.target.value})} value={this.state.totalSteps} id="generateStepsInput" type="number" className="form-control" min="1" max="30" placeholder="Choose the number of steps for your dish:"/>
                            </div>


                            <div id="steps">
                                {steps}
                            </div>

                            <div className="mb-3">
                                <label className="form-label">Define difficulty of dish:</label>
                                <select className="custom-select">
                                    {this.state.recipeDifficulties.map(item =>{
                                        return <option value={item.index}>{item}</option>
                                    })};
                                </select>
                            </div>

                            <button type="submit" className="btn btn-primary mb-2">Add dish</button>
                        </form>
                    </div>
                </div>
            </div>
        );
    }
}
