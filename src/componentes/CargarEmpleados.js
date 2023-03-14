import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import crud from '../conexiones/crud';
import ViewEmpleados from './ViewEmpleados';

const CargarEmpleados = () => {

  //const navigate = useNavigate();

  //const { idEmpleado } = useParams();

  const [empleados, setEmpleados] = useState([]);

  const cargarEmpleados = async () => {
    const response = await crud.GET(`/api/all`);
    //console.log(response);
    setEmpleados(response);
  }
  useEffect(() => {
    cargarEmpleados();
  }, []);

  return (
    <>
      <div className='md:flex md:min-h-screen'>
        <main className='flex-1'>
          <div className='mt-10 flex justify-center'>
            <h1 className="inline bg-gradient-to-r from-indigo-200 via-slate-400 to-indigo-200 bg-clip-text font-display text-5xl tracking-tight text-transparent">
              Listado de Empleados
            </h1>
          </div>

          <div className='p-12'>
            <Link
              to={`/`}
              className='bg-blue-500 w-full p-4 text-white uppercase font-bold mt-5 text-center rounded-lg'
            >Crear Empleado</Link>
          </div>
          <div className='p-12'>
            <Link
              to={`/ver-solicitudes`}
              className='bg-blue-500 w-full p-4 text-white uppercase font-bold mt-5 text-center rounded-lg'
            >Ver Solicitudes</Link>
          </div>

          <div className="bg-gray-600 shadow mt-10 rounded-lg">
            {empleados.map(empleado =>
              <ViewEmpleados
                key={empleado.id}
                empleado={empleado}
              />
            )}
          </div>

        </main>
      </div>

    </>
  );
}

export default CargarEmpleados;