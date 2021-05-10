import React, {Component} from "react";
import DishService from "../../services/dish.service";

class Step extends Component{
    constructor(props,number) {
        super(props);
        this.number = number;
        this.onChange=this.onChange.bind(this);
    }

    onChange = (event) => {
        this.setState({
            [event.target.name]: event.target.value
        })
    }

    render() {
        return (
            <div className="mb-4 my-step-class">
                <label className="form-label text-danger">Step nr {this.number}</label>
                <textarea onChange={this.onChange} className="form-control" placeholder="Description - Step " rows="3"/>
            </div>
        );
    }

}

export default Step;