import React, {Component} from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import AddDish from "./components/AddDish";
import { Route, Switch } from "react-router";
import Register from "./components/Register";
import Login from "./components/Login";
import Search from "./components/Search";
import Dish from "./components/Dish";
import PrivateRoute from './components/PrivateRoute';
import MainPage from "./components/MainPage";


class App extends Component {
  render() {
    return (
        <div className="App">
          <nav className="navbar navbar-expand-lg navbar-dark bg-dark main">
            <a className="navbar-brand" href="#">Oveneaten</a>
            <form className="form-inline">
              <button className="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
            <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            </button>
            <div className="collapse navbar-collapse" id="navbarSupportedContent">
              <ul className="navbar-nav ml-auto">
                <li className="nav-item dropdown">
                  <a className="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                     aria-haspopup="true" aria-expanded="false">
                    Recipies
                  </a>
                  <div className="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a className="dropdown-item" href="#">Breakfasts</a>
                    <a className="dropdown-item" href="#">Lunches</a>
                    <a className="dropdown-item" href="#">Dinners</a>
                    <a className="dropdown-item" href="#">Vegetarian dishes</a>
                    <a className="dropdown-item" href="#">Etc.</a>
                  </div>
                </li>
                <li className="nav-item">
                  <a className="nav-link" href="#">Tips&Tricks</a>
                </li>
                <li className="nav-item">
                  <a className="nav-link" href="#">Contact</a>
                </li>
                <a className="btn btn-outline-primary" href="#">Log in</a>
              </ul>
            </div>
          </nav>

          <div className="container col-12">
            <Switch>
              <PrivateRoute exact path="/addDish" component={AddDish} />
              <Route exact path="/api/auth/signup" component={Register} />
              <Route exact path="/api/auth/signin" component={Login} />
              <Route exact path="/search" component={Search} />
              <Route exact path="/dish" component={Dish} />
              <Route exact path="/mainPage" component={MainPage} />
            </Switch>
          </div>

        </div>
  );
  }
}

export default App;
