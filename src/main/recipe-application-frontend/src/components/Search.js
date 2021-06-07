import React, {Component} from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import App from "../App";
import DishService from "../services/dish.service"
import queryString from 'query-string';
import '../css/main.css'

class Search extends Component {


    constructor(props) {
        super(props);
        this.searchSpecificDishes = this.searchSpecificDishes.bind(this);
        this.convertValueToTimeUnit = this.convertValueToTimeUnit.bind(this);
        this.chunkArray = this.chunkArray.bind(this);

        this.state = {
            dishes: [],
            isDataFetched: false
        };

        DishService.searchDishes(new URLSearchParams(this.props.location.search).get("query")).then(
            response => {
                this.setState({
                    dishes: response.data,
                    isDataFetched: true
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

    searchSpecificDishes = (event) => {
        DishService.searchDishes({
            query: event.value
        }).then(response => {
            this.setState({
                dishes: response.data
            });
            console.log(response);
        }, error => {
            this.setState({
                content:
                    (error.response &&
                        error.response.data &&
                        error.response.data.message) ||
                    error.message ||
                    error.toString()
            });
        });
    };

    convertValueToTimeUnit(value) {
        switch (value) {
            case '1':
                return "minutes";
            case '2':
                return "hourse";
            case '3':
                return "days";
        }

    }

    chunkArray(myArray, chunk_size) {
        let index = 0;
        let arrayLength = myArray.length;
        let tempArray = [];

        for (index = 0; index < arrayLength; index += chunk_size) {
            let myChunk = myArray.slice(index, index + chunk_size);
            tempArray.push(myChunk);
        }

        return tempArray;
    }


    render() {

        const dishesCards = [];
        const fullContent = [];

        for (let i = 0; i < this.state.dishes.length; i++) {
            console.log(this.state.dishes[i]);
            dishesCards.push(
                    <div className="col-12 col-sm-6 col-md-4 "
                          >
                        <div className="card my-card mt-2 ml-2 my-card my-mouse-press"
                             onClick={() => window.location.href = `/recipe/${this.state.dishes[i].dishName}`}>
                            <img className="card-img-top"
                                 src={process.env.PUBLIC_URL + `/${this.state.dishes[i].image}`}
                                 alt="Card image cap"/>
                            <div className="card-body ">
                                <h5 className="card-title">{this.state.dishes[i].dishName}</h5>
                                <p className="card-text my-card-text">{this.state.dishes[i].dishDesc}</p>
                            </div>
                            <ul className="list-group list-group-flush">
                                <li className="list-group-item">Preparation
                                    time: {this.state.dishes[i].preparationTimeQuantity} {this.convertValueToTimeUnit(this.state.dishes[i].preparationTimeUnit)}</li>
                                <li className="list-group-item">Number of
                                    person: {this.state.dishes[i].numberOfPeople}</li>
                                <li className="list-group-item">Difficulty: {this.state.dishes[i].difficulty}</li>
                            </ul>
                        </div>
                    </div>
            )
        }

        const dishesGroups = this.chunkArray(dishesCards, 3);
        for (let i = 0; i < dishesGroups.length; i++) {
            fullContent.push(
                <div className="row">
                    {dishesGroups[i]}
                </div>
            )
        }

        if (!this.state.isDataFetched) return null;
        return (
            <div>
                <div className="row">
                    {dishesCards}
                </div>
            </div>);
    }

}

export default Search;