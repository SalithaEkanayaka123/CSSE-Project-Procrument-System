import './App.css';
import {BrowserRouter, Route, Switch} from 'react-router-dom';
import UserManagement from "./pages/UserManagment/UserManagment";
import Navbar from "./components/Navbar/Navbar";
import PageHeader from "./components/PageHeader/PageHeader";
import Payment from "./pages/Payment/Payment";

function App() {
  return (

    <div>
        <BrowserRouter>
            <Navbar/>
            <Switch>
                <Route exact path = "/home" />
                <Route exact path = "/usermanage" component={UserManagement}/>
                <Route exact path = "/payment" component={Payment}/>
            </Switch>
        </BrowserRouter>
    </div>
  );
}

export default App;
