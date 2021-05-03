import React, {Component} from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import App from "../App";

class Dish extends Component{
    render() {
        return (
            <div>
                <div className="container-fluid col-12 my-dish">
                    <div className="row">
                        <div className="col-7 mt-2">
                            <img className="d-block w-100 image-class  " src="../static/images/lunch.jpg"></img>
                        </div>
                        <div className="col-5 jumbotron jumbotron-fluid  bg-light text-dark pt-0">
                            <div className="container">
                                <h1 className="display-4">Lorem ipsum</h1>
                                <p className="lead">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean
                                    fringilla ligula a neque blandit auctor. Nulla viverra felis varius scelerisque
                                    facilisis. Mauris fermentum vulputate purus ac malesuada. Aliquam aliquam mi vel tempor
                                    dictum. Curabitur et sapien dignissim, lacinia eros non, pharetra diam.</p>
                                <hr className="my-4"></hr>
                                <h4>Preparation time : X</h4>
                                <hr className="my-4"></hr>
                                <h4>Number of person : X</h4>
                                <hr className="my-4"></hr>
                                <h4>Difficulty : X</h4>
                                <hr className="my-4"></hr>
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