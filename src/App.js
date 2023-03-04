import React from 'react';
import { BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import CargarEmpleados from './componentes/CargarEmpleados';
import CargarSolicitudes from './componentes/CargarSolicitudes';
import Home from './componentes/Home';
import Solicitud from './componentes/Solicitud';


function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" exact element={<Home/>} />
        <Route path="/ver-empleados" exact element={<CargarEmpleados/>} />
        <Route path="/crear-solicitud/:idEmpleado" exact element={<Solicitud/>} />
        <Route path="/ver-solicitudes" exact element={<CargarSolicitudes/>} />
      </Routes>
    </Router>
  );
}

export default App;