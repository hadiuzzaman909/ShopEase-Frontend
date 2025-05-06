import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'; 
import './App.css';
import './scss/main.scss';
import 'remixicon/fonts/remixicon.css';
import HomePage from './pages/HomePage';
import Header from './components/Header';
import Footer from './components/Footer';

function App() {
  return (
    <>
      <Router>
      <Header></Header>
        <Routes>
          <Route path="/" element={<HomePage />} />
        </Routes>
        <Footer/>
      </Router>
    </>
  );
}

export default App;

