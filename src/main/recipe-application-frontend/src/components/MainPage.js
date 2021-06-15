import React, {Component} from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import App from "../App";
import DishService from "../services/dish.service"
import '../css/main.css'

class MainPage extends Component {

    constructor(props) {
        super(props);
        this.linkMainRef = React.createRef();
        this.handleEnterPress = this.handleEnterPress.bind(this);
        this.state = {
            bestDishes: [],
            newestDishes: [],
            randomDishes: [],
            isDataFetched: false
        };

        DishService.getMainPage().then(
            response => {
                this.setState({
                    bestDishes : response.data.bestDishes,
                    newestDishes : response.data.newestDishes,
                    randomDishes : response.data.randomDishes,
                    isDataFetched : true
                });
                console.log(response)
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
            })


    }

    handleEnterPress = event => {
        if (event.key === 'Enter') {
            this.props.history.push(`/search?query=${this.linkRef.current}`)

        }

    };


    render() {
        if(!this.state.isDataFetched) return null;
        console.log(this.state.randomDishes[1]);
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
                                <div className="carousel-item active align-items-center my-carousel-class my-mouse-press main-carousel text-center" onClick={() => window.location.href = `/recipe/${this.state.randomDishes[0].id}`}>
                                    <img className="d-block w-100 image-class  " src={process.env.PUBLIC_URL + `/${this.state.randomDishes[0].image}`} alt="First slide"/>
                                    <div className="carousel-caption d-none d-md-block my-carousel-text text-dark ">
                                        <h5>{this.state.randomDishes[0].dishName}</h5>
                                    </div>
                                </div>
                                <div className="carousel-item align-items-center my-carousel-class my-mouse-press main-carousel text-center" onClick={() => window.location.href = `/recipe/${this.state.randomDishes[1].id}`}>
                                    <img className="d-block w-100 image-class  col-12" src={process.env.PUBLIC_URL + `/${this.state.randomDishes[1].image}`} alt="Second slide"/>
                                    <div className="carousel-caption d-none d-md-block my-carousel-text text-dark ">
                                        <h5>{this.state.randomDishes[1].dishName}</h5>
                                    </div>
                                </div>
                                <div className="carousel-item align-items-center my-carousel-class my-mouse-press main-carousel text-center" onClick={() => window.location.href = `/recipe/${this.state.randomDishes[2].id}`}>
                                    <img className="d-block w-100 image-class " src={process.env.PUBLIC_URL + `/${this.state.randomDishes[2].image}`} alt="Third slide"/>
                                    <div className="carousel-caption d-none d-md-block my-carousel-text text-dark ">
                                        <h5>{this.state.randomDishes[2].dishName}</h5>
                                    </div>
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
                                <p className="lead">Do you have unused ham, cheese and yeast in the fridge? You don't
                                    know what to do with the flour and honey that have been sitting around for a month.
                                    Oveneaten can help. Simply search the ingredients you have in the search bar and
                                    we'll recommend dishes you can make with them.

                                    You can also search for recipe using the traditional name.
                                </p>
                                <nav className="navbar navbar-light ">
                                    <form className="form-inline">
                                        <input className="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"
                                               onKeyPress={(event => this.handleEnterPress(event))} ref={this.linkMainRef}/>
                                        <button className="btn btn-outline-success my-2 my-sm-0"
                                                type="button"
                                                onClick={() => window.location.href = `/search?query=${this.linkMainRef.current.value}`}
                                                >Search
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
                                <li data-target="#carouselExampleIndicators" data-slide-to="0" className="active"/>
                                <li data-target="#carouselExampleIndicators" data-slide-to="1"/>
                                <li data-target="#carouselExampleIndicators" data-slide-to="2"/>
                            </ol>
                            <div className="carousel-inner ">
                                <div className="carousel-item active align-items-center ">
                                    <div className="row">
                                        <div className="col-sm-4 my-carousel-class my-mouse-press" onClick={() => window.location.href = `/recipe/${this.state.bestDishes[0].id}`}>
                                            <img className="d-block  best-dishes  " src={process.env.PUBLIC_URL + `/${this.state.bestDishes[0].image}`} alt="First slide"/>
                                            <div
                                                className="carousel-caption d-none d-md-block my-carousel-text text-dark">
                                                <h5>{this.state.bestDishes[0].dishName}</h5>
                                            </div>
                                        </div>
                                        <div className="col-sm-4 my-carousel-class my-mouse-press" onClick={() => window.location.href = `/recipe/${this.state.bestDishes[1].id}`}>
                                            <img className="d-block  best-dishes  " src={process.env.PUBLIC_URL + `/${this.state.bestDishes[1].image}`} alt="First slide"/>
                                            <div
                                                className="carousel-caption d-none d-md-block my-carousel-text text-dark">
                                                <h5>{this.state.bestDishes[1].dishName}</h5>
                                            </div>
                                        </div>
                                        <div className="col-sm-4 my-carousel-class my-mouse-press" onClick={() => window.location.href = `/recipe/${this.state.bestDishes[2].id}`}>
                                            <img className="d-block  best-dishes  " src={process.env.PUBLIC_URL + `/${this.state.bestDishes[2].image}`} alt="First slide"/>
                                            <div
                                                className="carousel-caption d-none d-md-block my-carousel-text text-dark">
                                                <h5>{this.state.bestDishes[2].dishName}</h5>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div className="carousel-item align-items-center ">
                                    <div className="row">
                                        <div className="col-sm-4 my-carousel-class my-mouse-press"  onClick={() => window.location.href = `/recipe/${this.state.bestDishes[3].id}`}>
                                            <img className="d-block  best-dishes  " src={process.env.PUBLIC_URL + `/${this.state.bestDishes[3].image}`} alt="Second slide"/>
                                            <div
                                                className="carousel-caption d-none d-md-block my-carousel-text text-dark">
                                                <h5>{this.state.bestDishes[3].dishName}</h5>
                                            </div>
                                        </div>
                                        <div className="col-sm-4 my-carousel-class my-mouse-press" onClick={() => window.location.href = `/recipe/${this.state.bestDishes[4].id}`}>
                                            <img className="d-block  best-dishes  " src={process.env.PUBLIC_URL + `/${this.state.bestDishes[4].image}`} alt="Second slide"/>
                                            <div
                                                className="carousel-caption d-none d-md-block my-carousel-text text-dark">
                                                <h5>{this.state.bestDishes[4].dishName}</h5>
                                            </div>
                                        </div>
                                        <div className="col-sm-4 my-carousel-class my-mouse-press"  onClick={() => window.location.href = `/recipe/${this.state.bestDishes[5].id}`}>
                                            <img className="d-block  best-dishes  " src={process.env.PUBLIC_URL + `/${this.state.bestDishes[5].image}`} alt="Second slide"/>
                                            <div
                                                className="carousel-caption d-none d-md-block my-carousel-text text-dark">
                                                <h5>{this.state.bestDishes[5].dishName}</h5>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div className="carousel-item align-items-center">
                                    <div className="row">
                                        <div className="col-sm-4 my-carousel-class my-mouse-press"  onClick={() => window.location.href = `/recipe/${this.state.bestDishes[6].id}`}>
                                            <img className="d-block  best-dishes " src={process.env.PUBLIC_URL + `/${this.state.bestDishes[6].image}`} alt="Third slide"/>
                                            <div
                                                className="carousel-caption d-none d-md-block my-carousel-text text-dark">
                                                <h5>{this.state.bestDishes[6].dishName}</h5>
                                            </div>
                                        </div>
                                        <div className="col-sm-4 my-carousel-class my-mouse-press" onClick={() => window.location.href = `/recipe/${this.state.bestDishes[7].id}`} >
                                            <img className="d-block  best-dishes " src={process.env.PUBLIC_URL + `/${this.state.bestDishes[7].image}`} alt="Third slide"/>
                                            <div
                                                className="carousel-caption d-none d-md-block my-carousel-text text-dark">
                                                <h5>{this.state.bestDishes[7].dishName}</h5>
                                            </div>
                                        </div>
                                        <div className="col-sm-4 my-carousel-class my-mouse-press"  onClick={() => window.location.href = `/recipe/${this.state.bestDishes[8].id}`}>
                                            <img className="d-block  best-dishes " src={process.env.PUBLIC_URL + `/${this.state.bestDishes[8].image}`} alt="Third slide"/>
                                            <div
                                                className="carousel-caption d-none d-md-block my-carousel-text text-dark">
                                                <h5>{this.state.bestDishes[8].dishName}</h5>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <a className="carousel-control-prev" href="#bestDishes" role="button" data-slide="prev">
                                <span className="carousel-control-prev-icon" aria-hidden="true"/>
                                <span className="sr-only">Previous</span>
                            </a>
                            <a className="carousel-control-next" href="#bestDishes" role="button" data-slide="next">
                                <span className="carousel-control-next-icon" aria-hidden="true"/>
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
                                <li data-target="#newestDishes" data-slide-to="0" className="active"/>
                                <li data-target="#newestDishes" data-slide-to="1"/>
                                <li data-target="#newestDishes" data-slide-to="2"/>
                            </ol>
                            <div className="carousel-inner ">
                                <div className="carousel-item active align-items-center ">
                                    <div className="row">
                                        <div className="col-sm-12 col-lg-4 my-carousel-class my-mouse-press" onClick={() => window.location.href = `/recipe/${this.state.newestDishes[0].id}`}>
                                            <img className="d-block  best-dishes  " src={process.env.PUBLIC_URL + `/${this.state.newestDishes[0].image}`} alt="First slide"/>
                                            <div
                                                className="carousel-caption d-none d-md-block my-carousel-text text-dark">
                                                <h5>{this.state.newestDishes[0].dishName}</h5>
                                            </div>
                                        </div>
                                        <div className="col-sm-12 col-lg-4 my-carousel-class my-mouse-press" onClick={() => window.location.href = `/recipe/${this.state.newestDishes[1].id}`}>
                                            <img className="d-block  best-dishes  " src={process.env.PUBLIC_URL + `/${this.state.newestDishes[1].image}`} alt="First slide"/>
                                            <div
                                                className="carousel-caption d-none d-md-block my-carousel-text text-dark">
                                                <h5>{this.state.newestDishes[1].dishName}</h5>
                                            </div>
                                        </div>
                                        <div className="col-sm-12 col-lg-4 my-carousel-class my-mouse-press" onClick={() => window.location.href = `/recipe/${this.state.newestDishes[2].id}`}>
                                            <img className="d-block  best-dishes  " src={process.env.PUBLIC_URL + `/${this.state.newestDishes[2].image}`} alt="First slide"/>
                                            <div
                                                className="carousel-caption d-none d-md-block my-carousel-text text-dark">
                                                <h5>{this.state.newestDishes[2].dishName}</h5>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div className="carousel-item align-items-center ">
                                    <div className="row">
                                        <div className="col-sm-12 col-lg-4 my-carousel-class my-mouse-press" onClick={() => window.location.href = `/recipe/${this.state.newestDishes[3].id}`}>
                                            <img className="d-block  best-dishes  " src={process.env.PUBLIC_URL + `/${this.state.newestDishes[3].image}`} alt="Second slide"/>
                                            <div
                                                className="carousel-caption d-none d-md-block my-carousel-text text-dark">
                                                <h5>{this.state.newestDishes[3].dishName}</h5>
                                            </div>
                                        </div>
                                        <div className="col-sm-12 col-lg-4 my-carousel-class my-mouse-press" onClick={() => window.location.href = `/recipe/${this.state.newestDishes[4].id}`}>
                                            <img className="d-block  best-dishes  " src={process.env.PUBLIC_URL + `/${this.state.newestDishes[4].image}`} alt="Second slide"/>
                                            <div
                                                className="carousel-caption d-none d-md-block my-carousel-text text-dark">
                                                <h5>{this.state.newestDishes[4].dishName}</h5>
                                            </div>
                                        </div>
                                        <div className="col-sm-12 col-lg-4 my-carousel-class my-mouse-press" onClick={() => window.location.href = `/recipe/${this.state.newestDishes[5].id}`}>
                                            <img className="d-block  best-dishes  " src={process.env.PUBLIC_URL + `/${this.state.newestDishes[5].image}`} alt="Second slide"/>
                                            <div
                                                className="carousel-caption d-none d-md-block my-carousel-text text-dark">
                                                <h5>{this.state.newestDishes[5].dishName}</h5>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div className="carousel-item align-items-center">
                                    <div className="row">
                                        <div className="col-sm-12 col-lg-4 my-carousel-class my-mouse-press" onClick={() => window.location.href = `/recipe/${this.state.newestDishes[6].id}`}>
                                            <img className="d-block  best-dishes " src={process.env.PUBLIC_URL + `/${this.state.newestDishes[6].image}`} alt="Third slide"/>
                                            <div
                                                className="carousel-caption d-none d-md-block my-carousel-text text-dark">
                                                <h5>{this.state.newestDishes[6].dishName}</h5>
                                            </div>
                                        </div>
                                        <div className="col-sm-12 col-lg-4 my-carousel-class my-mouse-press" onClick={() => window.location.href = `/recipe/${this.state.newestDishes[7].id}`}>
                                            <img className="d-block  best-dishes " src={process.env.PUBLIC_URL + `/${this.state.newestDishes[7].image}`} alt="Third slide"/>
                                            <div
                                                className="carousel-caption d-none d-md-block my-carousel-text text-dark">
                                                <h5>{this.state.newestDishes[7].dishName}</h5>
                                            </div>
                                        </div>
                                        <div className="col-sm-12 col-lg-4 my-carousel-class my-mouse-press" onClick={() => window.location.href = `/recipe/${this.state.newestDishes[8].id}`}>
                                            <img className="d-block  best-dishes " src={process.env.PUBLIC_URL + `/${this.state.newestDishes[8].image}`} alt="Third slide"/>
                                            <div
                                                className="carousel-caption d-none d-md-block my-carousel-text text-dark">
                                                <h5>{this.state.newestDishes[8].dishName}</h5>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <a className="carousel-control-prev" href="#newestDishes" role="button" data-slide="prev">
                                <span className="carousel-control-prev-icon" aria-hidden="true"/>
                                <span className="sr-only">Previous</span>
                            </a>
                            <a className="carousel-control-next" href="#newestDishes" role="button" data-slide="next">
                                <span className="carousel-control-next-icon" aria-hidden="true"/>
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