import React, { useState }  from 'react';
import crud from '../conexiones/crud';
import {  Link, useNavigate, useParams  } from 'react-router-dom';

export const Solicitud = ({empleado}) =>{

const navigate = useNavigate();

const {idEmpleado} = useParams();


  const [solicitud, setSolicitud] = useState({
    codigo:'',
    descripcion:'',
    resumen:'',
    empleadoId:''

  })
  const { codigo, descripcion, resumen} = solicitud;

  const onChange = (e) =>{
    setSolicitud({
      ...solicitud,
      [e.target.name]: e.target.value
    })
  }

  const crearSolicitud = async () =>{
    const data = {
      codigo: solicitud.codigo,
      descripcion: solicitud.descripcion,
      resumen: solicitud.resumen,
      empleadoId: idEmpleado
    }
   
  
    const response = await crud.POST(`/api/solicitud/empleado/${idEmpleado}`, data);
      const mensaje = response.mensaje;
      console.log(mensaje);
      setSolicitud({
        codigo:'',
        descripcion:'',
        resumen:'',
      });
      
      
}
const onSubmit = (e) => {
  e.preventDefault();
  crearSolicitud();
}

return (
    <>
    <main className='container mx-auto mt-5 md:mt-20 p-5 md:flex md:justify-center'>
       <div className='md:w-2/3 lg:w-2/5'>
          <div className='flex justify-center'>
            <h1 className="inline bg-gradient-to-r from-indigo-200 via-slate-400 to-indigo-200 bg-clip-text font-display text-5xl tracking-tight text-transparent m-10" >
             Crear Solicitudes
            </h1>
          </div>
          

          <form 
            className='my-10 bg-gray-700 shadow rounded-lg p-10 '
            onSubmit={onSubmit}
          >
            <div className='my-5'>
              <label className='uppercase text-white block text-xl font-bold' >Codigo</label>
              <input
                type="text"
                id="codigo"
                name="codigo"
                placeholder='Codigo'
                className='w-full mt-3 p-3 border rounded-lg bg-gray-50'
                value={codigo}
                onChange={onChange}
              />

          <label className='uppercase text-white block text-xl font-bold' >Descripcion</label>
              <input
                type="descripcion"
                id="descripcion"
                name="descripcion"
                placeholder='Descripcion'
                className='w-full mt-3 p-3 border rounded-lg bg-gray-50'
                value={descripcion}
                onChange={onChange}
              />
          <label className='uppercase text-white block text-xl font-bold' >resumen</label>
              <input
                type="resumen"
                id="resumen"
                name="resumen"
                placeholder='Resumen'
                className='w-full mt-3 p-3 border rounded-lg bg-gray-50'
                value={resumen}
                onChange={onChange}
              />

            </div>
              
            <input 
              type="submit"
              value="Crear Solicitud"
              className="bg-blue-500 mb-5 w-full py-3 text-white uppercase font-bold rounded hover:cursor-pointer hover:bg-blue-300  transition-colors"
          />
          <Link 
          to={"/"}
          className="block text-center my-5 text-blue-500  uppercase text-sm"
          >Crear Empleado</Link>

          <Link 
          to={"/ver-solicitudes"}
          className="block text-center my-5 text-blue-500  uppercase text-sm"
          >Ver Solicitudes</Link>
          </form>
       </div>
       
    </main>
    </>
  );

}

export default Solicitud;