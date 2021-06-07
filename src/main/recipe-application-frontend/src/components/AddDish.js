import React, {Component, useEffect, useRef} from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import App from "../App";
import DishService from "../services/dish.service";
import UploadFilesService from "../services/upload-files.service";
import Form from "react-validation/build/form";
import Input from "react-validation/build/input";
import CheckButton from "react-validation/build/button";
import { isEmail } from "validator";
import AuthService from "../services/auth.service"



export default class AddDish extends Component{

    changeStepHandler = (event,index) => {
        const newSteps = [...this.state.selectedSteps];
        newSteps[index] = event.target.value.replace(/,/g, ' ');
        this.setState({selectedSteps : newSteps});
        console.log(newSteps);
    }

    changeIngredientsHandler = (event,index) => {
        const newIngredients = [...this.state.selectedIngredients];
        newIngredients[index] = event.target.value.replace(/,/g, ' ');
        this.setState({selectedIngredients : newIngredients});
        console.log(newIngredients);
    }

    changeIngredientsUnitsHandler = (event,index) => {
        const newIngredientsUnits = [...this.state.selectedIngredientsUnits];
        newIngredientsUnits[index] = event.target.value;
        this.setState({selectedIngredientsUnits : newIngredientsUnits});
        console.log(newIngredientsUnits);
    }

    changeIngredientsQuantitiesHandler = (event,index) => {
        const newIngredientsQuantities = [...this.state.selectedIngredientsQuantities];
        newIngredientsQuantities[index] = event.target.value.replace(/,/g, '.') ;
        this.setState({selectedIngredientsQuantities : newIngredientsQuantities});
        console.log(newIngredientsQuantities);
    }

    uploadDish = (event) => {
        event.preventDefault();
        console.log(
            this.state.selectedFile,
            this.selectedName.current.value,
            this.selectedDescription.current.value,
            this.selectedPreparationTimeQuantity.current.value,
            this.selectedPreparationTimeUnit.current.value,
            this.selectedNumberOfPeople.current.value,
            this.selectedDifficulty.current.value,
            this.state.selectedSteps,
            this.state.selectedIngredients,
            this.state.selectedIngredientsUnits,
            this.state.selectedIngredientsQuantities);
        UploadFilesService.upload(
            this.state.selectedFile,
            this.selectedName.current.value,
            this.selectedDescription.current.value,
            this.selectedPreparationTimeQuantity.current.value,
            this.selectedPreparationTimeUnit.current.value,
            this.selectedNumberOfPeople.current.value,
            this.selectedDifficulty.current.value,
            this.state.selectedSteps,
            this.state.selectedIngredients,
            this.state.selectedIngredientsUnits,
            this.state.selectedIngredientsQuantities
        )
        .then(response => console.log(response))
        .catch(error => console.log(error));
    };


    constructor(props) {
        super(props);
        this.selectedName = React.createRef();
        this.selectedDescription=React.createRef();
        this.selectedPreparationTimeQuantity = React.createRef();
        this.selectedPreparationTimeUnit = React.createRef();
        this.selectedNumberOfPeople = React.createRef();
        this.selectedDifficulty = React.createRef();

        this.uploadDish = this.uploadDish.bind(this);


        this.state = {
            ingredientUnitList: [],
            recipeDifficulties: [],
            totalSteps: 0,
            totalStepsInput: '',
            totalIngredients: 0,
            totalIngredientsInput: '',
            selectedFile: null,
            selectedSteps: [],
            selectedIngredients: [],
            selectedIngredientsUnits: [],
            selectedIngredientsQuantities: []
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
    };

    onFileChange = event => {
        this.setState({ selectedFile: event.target.files[0] });
    };

    addIngredients = ()=>{
        this.setState({
            totalIngredients: this.state.totalIngredientsInput
        })
    }


    render() {

        const ingredients = [];
        const steps = [];
        for(let i=1;i<=this.state.totalSteps;i++){

            steps.push(
                <div className="mb-4 my-step-class">
                    <label className="form-label text-danger">Step nr {i}</label>
                    <textarea onChange={action => this.changeStepHandler(action,i)} className="form-control" placeholder="Description - step " rows="3"/>
                </div>
            )
        }
        for(let i=1;i<=this.state.totalIngredients;i++){

            ingredients.push(
                <div className="mb-4 my-ingredient-class">
                    <label className="form-label text-info">Ingredient nr {i}</label>
                    <input type="text" onChange={action => this.changeIngredientsHandler(action,i)}  className="form-control" aria-describedby="usernameHelp"/>
                    <label className="form-label">Amount of the ingredient</label>
                    <div className="row">
                        <div className="col-7">
                            <input type="number" step=".01" onChange={action => this.changeIngredientsQuantitiesHandler(action,i)} className="form-control" min="0" max="1000"/>
                        </div>
                        <div className="col-5">
                            <select onChange={action => this.changeIngredientsUnitsHandler(action,i)}  className="custom-select">
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
                                <input type="text" ref={this.selectedName} className="form-control" id="dishNameInput" aria-describedby="usernameHelp"/>
                            </div>
                            <div className="mb-3">
                                <label htmlFor="dishDescription" className="form-label">Description</label>
                                <textarea ref={this.selectedDescription} className="form-control" id="dishDescription" rows="3"/>
                            </div>
                            <div className="mb-3">
                                <label htmlFor="uploadImage" className="form-label">Upload image</label>
                                <input type="file" accept="image/*" className="form-control" id="uploadImage" onChange={this.onFileChange} />
                            </div>
                            <div className="mb-3">
                                <label className="form-label">Preparation time</label>
                                <div className="row">
                                    <div className="col-7">
                                        <input type="number" ref={this.selectedPreparationTimeQuantity} className="form-control" min="1" max="1000"/>
                                    </div>
                                    <div className="col-5">
                                        <select ref={this.selectedPreparationTimeUnit} className="custom-select">
                                            <option value="1">minutes</option>
                                            <option value="2">hours</option>
                                            <option value="3">days</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div className="mb-3">
                                <label className="form-label">For how many people will this dish be?</label>
                                <input type="number" ref={this.selectedNumberOfPeople} className="form-control" min="1" max="12"/>
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
                                <label className="form-label">Define difficulty123 of dish:</label>
                                <select ref={this.selectedDifficulty} className="custom-select">
                                    {this.state.recipeDifficulties.map(item =>{
                                        return <option value={item.index}>{item}</option>
                                    })};
                                </select>
                            </div>

                            <button onClick={this.uploadDish} className="btn btn-primary mb-2">Add dish</button>

                        </form>
                    </div>
                </div>
            </div>
        );
    }
}
