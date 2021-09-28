import logo from './logo.svg';
import './App.css';
import UserManagement from "./pages/UserManagment/UserManagment";
import Navbar from "./components/Navbar/Navbar";
import PageHeader from "./components/PageHeader/PageHeader";

function App() {
  return (
    <div>
        <Navbar/>
      <UserManagement/>
    </div>
  );
}

export default App;
