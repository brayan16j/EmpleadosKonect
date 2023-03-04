import React, { useState, useEffect } from 'react'; 
import { Link, useNavigate, useParams} from 'react-router-dom';
import crud from '../conexiones/crud';
import ViewSolicitudes from './ViewSolicitudes';

const CargarSolicitudes = () => {
  
  const navigate = useNavigate(); 
 
  const {idSolicitud} = useParams();

    useEffect(() => {
        cargarSolicitudes();
    },[]);

    const [solicitudes, setSolicitudes] = useState([]);

    const cargarSolicitudes = async () => {
        const response = await crud.GET(`/api/solicitud/all`);
        //console.log(response);
        setSolicitudes(response);
      }
  return (
      <>
      <div className='md:flex md:min-h-screen'>
            <main className= 'flex-1'>
              <div className='mt-10 flex justify-center'>
              <h1 className="inline bg-gradient-to-r from-indigo-200 via-slate-400 to-indigo-200 bg-clip-text font-display text-5xl tracking-tight text-transparent">
                Listado de Solicitudes
                </h1>
                </div>  
              
            <div className='p-12'>
              <Link
                to={`/`}
                className='bg-blue-500 w-full p-3 text-white uppercase font-bold mt-5 text-center rounded-lg'
              >Crear Empleado</Link>
            </div>

          <div className="bg-gray-600 shadow mt-10 rounded-lg">
            {solicitudes.map( solicitud =>
              <ViewSolicitudes
                key={solicitud.id}
                solicitud={solicitud}
              />
            )}
          </div>

            </main>
        </div>   

</>
    );
}

export default CargarSolicitudes;