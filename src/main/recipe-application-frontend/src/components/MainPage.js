import React, {Component} from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import App from "../App";

class MainPage extends Component{
    render() {
        return (
            <div>
            <div className="container-fluid col-12 main-container ">
                <div className="row">
                    <div id="carouselExampleIndicators" className="carousel slide p-0  col-12 col-lg-7 bg-light"
                         data-ride="carousel">
                        <ol className="carousel-indicators">
                            <li data-target="#carouselExampleIndicators" data-slide-to="0" className="active"/>
                            <li data-target="#carouselExampleIndicators" data-slide-to="1"/>
                            <li data-target="#carouselExampleIndicators" data-slide-to="2"/>
                        </ol>
                        <div className="carousel-inner ">
                            <div className="carousel-item active align-items-center ">
                                <img className="d-block w-100 image-class  " src="../static/images/lunch.jpg" alt="First slide"/>
                            </div>
                            <div className="carousel-item align-items-center ">
                                <img className="d-block w-100 image-class  col-12" src="../static/images/breakfast.jpg" alt="Second slide"/>
                            </div>
                            <div className="carousel-item align-items-center">
                                <img className="d-block w-100 image-class " src="../static/images/dinner.jpg" alt="Third slide"/>
                            </div>
                        </div>
                        <a className="carousel-control-prev" href="#carouselExampleIndicators" role="button"
                           data-slide="prev">
                            <span className="carousel-control-prev-icon" aria-hidden="true"/>
                            <span className="sr-only">Previous</span>
                        </a>
                        <a className="carousel-control-next" href="#carouselExampleIndicators" role="button"
                           data-slide="next">
                            <span className="carousel-control-next-icon" aria-hidden="true"/>
                            <span className="sr-only">Next</span>
                        </a>
                    </div>
                    <div className="jumbotron jumbotron-fluid  bg-light text-dark col-12 col-lg-5 m-0">
                        <div className="container">
                            <h1 className="display-4">Oveneaten</h1>
                            <p className="lead">Do you have unused ham, cheese and yeast in the fridge? You don't know
                                what to do with the flour and honey that have been sitting around for a month. Oveneaten
                                can help. Simply search the ingredients you have in the search bar and we'll recommend
                                dishes you can make with them.

                                You can also search for recipe using the traditional name.
                            </p>
                            <nav className="navbar navbar-light ">
                                <form className="form-inline">
                                    <input className="form-control mr-sm-2" type="search" placeholder="Search"
                                           aria-label="Search"></input>
                                        <button className="btn btn-outline-success my-2 my-sm-0" type="submit">Search
                                        </button>

                                </form>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>



        <p className="h3 text-dark  m-lg-2">Best dishes</p>

        <div className="container main-container mt-1 col-12">
            <div className="row">
                <div id="bestDishes" className="carousel slide bg-light col-12" data-ride="carousel">
                    <ol className="carousel-indicators">
                        <li data-target="#carouselExampleIndicators" data-slide-to="0" className="active"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                    </ol>
                    <div className="carousel-inner ">
                        <div className="carousel-item active align-items-center ">
                            <div className="row">
                                <div className="col-sm-4">
                                    <img className="d-block  best-dishes  " src="../static/images/lunch2.jpg"
                                         alt="First slide"></img>
                                </div>
                                <div className="col-sm-4">
                                    <img className="d-block  best-dishes  " src="../static/images/lunch1.jfif"
                                         alt="First slide"></img>
                                </div>
                                <div className="col-sm-4">
                                    <img className="d-block  best-dishes  " src="../static/images/lunch3.jpg"
                                         alt="First slide"></img>
                                </div>
                            </div>
                        </div>
                        <div className="carousel-item align-items-center ">
                            <div className="row">
                                <div className="col-sm-4">
                                    <img className="d-block  best-dishes  " src="../static/images/breakfast1.jpg"
                                         alt="Second slide"></img>
                                </div>
                                <div className="col-sm-4">
                                    <img className="d-block  best-dishes  " src="../static/images/breakfast2.jpg"
                                         alt="Second slide"></img>
                                </div>
                                <div className="col-sm-4">
                                    <img className="d-block  best-dishes  " src="../static/images/breakfast3.jpg"
                                         alt="Second slide"></img>
                                </div>
                            </div>
                        </div>
                        <div className="carousel-item align-items-center">
                            <div className="row">
                                <div className="col-sm-4">
                                    <img className="d-block  best-dishes " src="../static/images/dinner1.jfif"
                                         alt="Third slide"></img>
                                </div>
                                <div className="col-sm-4">
                                    <img className="d-block  best-dishes " src="../static/images/dinner2.jpg"
                                         alt="Third slide"></img>
                                </div>
                                <div className="col-sm-4">
                                    <img className="d-block  best-dishes " src="../static/images/dinner3.jpg"
                                         alt="Third slide"></img>
                                </div>
                            </div>
                        </div>
                    </div>
                    <a className="carousel-control-prev" href="#bestDishes" role="button" data-slide="prev">
                        <span className="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span className="sr-only">Previous</span>
                    </a>
                    <a className="carousel-control-next" href="#bestDishes" role="button" data-slide="next">
                        <span className="carousel-control-next-icon" aria-hidden="true"></span>
                        <span className="sr-only">Next</span>
                    </a>
                </div>
            </div>
        </div>
        <p className="h3 text-dark m-lg-2">Newest dishes</p>
        <div className="container main-container mt-1 col-12">
            <div className="row">
                <div id="newestDishes" className="carousel slide bg-light col-12" data-ride="carousel">
                    <ol className="carousel-indicators">
                        <li data-target="#newestDishes" data-slide-to="0" className="active"></li>
                        <li data-target="#newestDishes" data-slide-to="1"></li>
                        <li data-target="#newestDishes" data-slide-to="2"></li>
                    </ol>
                    <div className="carousel-inner ">
                        <div className="carousel-item active align-items-center ">
                            <div className="row">
                                <div className="col-sm-4">
                                    <img className="d-block  best-dishes  " src="../static/images/lunch2.jpg"
                                         alt="First slide"></img>
                                </div>
                                <div className="col-sm-4">
                                    <img className="d-block  best-dishes  " src="../static/images/lunch1.jfif"
                                         alt="First slide"></img>
                                </div>
                                <div className="col-sm-4">
                                    <img className="d-block  best-dishes  " src="../static/images/lunch3.jpg"
                                         alt="First slide"></img>
                                </div>
                            </div>
                        </div>
                        <div className="carousel-item align-items-center ">
                            <div className="row">
                                <div className="col-sm-4">
                                    <img className="d-block  best-dishes  " src="../static/images/breakfast1.jpg"
                                         alt="Second slide"></img>
                                </div>
                                <div className="col-sm-4">
                                    <img className="d-block  best-dishes  " src="../static/images/breakfast2.jpg"
                                         alt="Second slide"></img>
                                </div>
                                <div className="col-sm-4">
                                    <img className="d-block  best-dishes  " src="../static/images/breakfast3.jpg"
                                         alt="Second slide"></img>
                                </div>
                            </div>
                        </div>
                        <div className="carousel-item align-items-center">
                            <div className="row">
                                <div className="col-sm-4">
                                    <img className="d-block  best-dishes " src="../static/images/dinner1.jfif"
                                         alt="Third slide"></img>
                                </div>
                                <div className="col-sm-4">
                                    <img className="d-block  best-dishes " src="../static/images/dinner2.jpg"
                                         alt="Third slide"></img>
                                </div>
                                <div className="col-sm-4">
                                    <img className="d-block  best-dishes " src="../static/images/dinner3.jpg"
                                         alt="Third slide"></img>
                                </div>
                            </div>
                        </div>
                    </div>
                    <a className="carousel-control-prev" href="#newestDishes" role="button" data-slide="prev">
                        <span className="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span className="sr-only">Previous</span>
                    </a>
                    <a className="carousel-control-next" href="#newestDishes" role="button" data-slide="next">
                        <span className="carousel-control-next-icon" aria-hidden="true"></span>
                        <span className="sr-only">Next</span>
                    </a>
                </div>
            </div>
        </div>
        </div>
    );
    }
}

export default MainPage;