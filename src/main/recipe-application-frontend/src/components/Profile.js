import React, {Component, useEffect, useRef} from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import "../css/profile.css"
import App from "../App";
import DishService from "../services/dish.service";
import UploadFilesService from "../services/upload-files.service";
import Form from "react-validation/build/form";
import Input from "react-validation/build/input";
import CheckButton from "react-validation/build/button";
import {isEmail} from "validator";
import AuthService from "../services/auth.service"
import {BookOpen, Star, Settings, User, Eye, Edit, Trash2} from 'react-feather';

export default class Profile extends Component {
    constructor(props) {
        super(props);
        let username = JSON.parse(localStorage.getItem('user')).username;
        let email = JSON.parse(localStorage.getItem('user')).email;
        let phone = JSON.parse(localStorage.getItem('user')).phone;
        let roles = JSON.parse(localStorage.getItem('user')).roles;
        let ifAdmin = roles.includes("ROLE_ADMIN");

        this.state = {
            email: email,
            userName: username,
            phone: phone,
            dishes: [],
            users: [],
            admin: ifAdmin

        };

        DishService.getUserDishes().then(
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

        AuthService.getAllUsers().then(
            response => {
                this.setState({
                    users: response.data
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

    deleteUser = (event,email) => {
        AuthService.deleteUser(email).then(r => console.log(r));
        if(email.localeCompare(this.state.email)===0){
            localStorage.removeItem('user');
            window.location.reload();
        }
    }



    render() {

        let myDishes=[];
        let users=[];

        for (let i = 0; i < this.state.dishes.length; i++) {
            console.log(this.state.dishes[i]);
            myDishes.push(
                <div className="card mb-3">
                    <img className="card-img-top" src={process.env.PUBLIC_URL + `/${this.state.dishes[i].image}`} alt="Card image cap"/>
                    <div className="card-body">
                        <h5 className="card-title">{this.state.dishes[i].dishName}</h5>
                        <p className="card-text">{this.state.dishes[i].dishDesc}</p>
                    </div>
                </div>
            )
        }

        for (let i = 0; i < this.state.users.length; i++) {
            console.log(this.state.users[i]);
            users.push(
                <tr>
                    <th scope="row">{i}</th>
                    <td>{this.state.users[i].username}</td>
                    <td>{this.state.users[i].email}</td>
                    <td>
                        <button type="button" className="btn btn-danger special-button"
                                onClick={event => this.deleteUser(event,this.state.users[i].email)}>
                            <Trash2 className="justify-content-center"/> Delete user
                        </button>
                    </td>
                </tr>
            )
        }

        return (
            <div className="row">
                <div className="card">
                    <div className="card-body navigation-card">
                        <nav className="nav flex-column nav-pills nav-gap-y-1">
                            <a href="#profile" data-toggle="tab"
                               className="nav-item nav-link has-icon nav-link-faded active">
                                <User/>
                                <span className="ml-2">Profile information</span>
                            </a>
                            <a href="#security" data-toggle="tab" className="nav-item nav-link has-icon nav-link-faded">
                                <BookOpen/>
                                <span className="ml-2">My recipes</span>
                            </a>
                            {this.state.admin && (
                                <a href="#notification" data-toggle="tab"
                                                     className="nav-item nav-link has-icon nav-link-faded">
                                <Star/>
                                <span className="ml-2">Admin panel</span>
                            </a>
                            )}
                        </nav>
                    </div>
                </div>
                <div className="col-md-8">
                    <div className="card">
                        <div className="card-header border-bottom mb-3 d-flex d-md-none">
                            <ul className="nav nav-tabs card-header-tabs nav-gap-x-1" role="tablist">
                                <li className="nav-item">
                                    <a href="#profile" data-toggle="tab" className="nav-link has-icon active">
                                        <User/>
                                    </a>
                                </li>
                                <li className="nav-item">
                                    <a href="#security" data-toggle="tab" className="nav-link has-icon">
                                        <BookOpen/>
                                    </a>
                                </li>
                                {this.state.admin && (
                                    <li className="nav-item">
                                        <a href="#notification" data-toggle="tab" className="nav-link has-icon">
                                            <Star/>
                                        </a>
                                    </li>
                                )}
                            </ul>
                        </div>
                        <div className="card-body tab-content">
                            <div className="tab-pane active" id="profile">
                                <h6>YOUR PROFILE INFORMATION</h6>
                                <hr/>
                                <form>
                                    <div className="form-group">
                                        <label htmlFor="fullEmail">Email</label>
                                        <input type="text" className="form-control" id="fullEmail"
                                               aria-describedby="fullNameHelp" value={this.state.email} disabled/>
                                    </div>
                                    <div className="form-group">
                                        <label htmlFor="fullPhone">Phone number</label>
                                        <input type="phone" className="form-control" id="fullPhone"
                                               aria-describedby="fullNameHelp" value={this.state.phone} disabled/>
                                    </div>
                                    <div className="form-group">
                                        <label htmlFor="fullUsername">Username</label>
                                        <input type="phone" className="form-control" id="fullUsername"
                                               aria-describedby="fullNameHelp" value={this.state.userName} disabled/>
                                    </div>
                                </form>
                            </div>
                            <div className="tab-pane" id="security">
                                <h6>MY DIHES</h6>
                                <hr/>
                                {myDishes}
                            </div>
                            {this.state.admin && (
                                <div className="tab-pane" id="notification">
                                    <h6>USERS</h6>
                                    <hr/>
                                    <table className="table table-bordered">
                                        <thead>
                                        <tr>
                                            <th scope="col">Nr</th>
                                            <th scope="col">Username</th>
                                            <th scope="col">Email</th>
                                            <th scope="col">Actions</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        {users}
                                        </tbody>
                                    </table>
                                </div>
                            )}
                            <div className="tab-pane" id="billing">
                                <h6>BILLING SETTINGS</h6>
                                <hr/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}
