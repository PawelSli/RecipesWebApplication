import React, {Component} from "react";
import DishService from "../../services/dish.service";

class Ingredient extends Component{
    constructor(props,number,list) {
        super(props);
        this.number = number;
        this.list = list;
        this.buildList =this.buildList.bind(this);
        this.onChange=this.onChange.bind(this);
    }

    onChange = (event) => {
        this.setState({
            [event.target.name]: event.target.value
        })
    }

    buildList(givenList){
        console.log(givenList);
        const arr = [];
        /*for (let i = 0; i < givenList.length; i++) {
            arr.push(<option value={i+1}>{this.givenList[i]}</option>)
        }*/
        givenList.map(item=>{
            arr.push(<option value={item.index}>{item.name}</option>)
        });
        console.log(arr);
        return arr;
    }

    render() {
        return (
            <div className="mb-4 my-ingredient-class">
                <label className="form-label text-info">Ingredient nr {this.number}</label>
                <input type="text" className="form-control" aria-describedby="usernameHelp">
                    <label className="form-label">Amount of the ingredient</label>
                    <div className="row">
                        <div className="col-7">
                            <input onChange={this.onChange} type="number" className="form-control" min="1" max="1000"/>
                        </div>
                        <div className="col-5">
                            <select className="custom-select">
                                {this.buildList(this.list)}
                            </select>
                        </div>
                    </div>
                </input>
            </div>
        );
    }
}

export default Ingredient;