import React from 'react';
import {   useNavigate, useParams  } from 'react-router-dom';

export const ViewSolicitudes = ({solicitud}) =>{
    console.log(solicitud);
    const navigate = useNavigate();

    const {idSolicitud} = useParams();
    console.log(idSolicitud);

  const {id, codigo, descripcion, resumen} = solicitud;
  //const {id} = key;
   
   
    return(
        <div
            className='border-r p-5 flex justify-between items-center'
        >
            <div className='flex flex-col items-start'>
                <p className='mb-1 text-xl text-gray-50'>Id : {id}</p>
                <p className='mb-1 text-xl text-gray-50'>Codigo : {codigo}</p>
                <p className='mb-1 text-xl text-gray-50 '>Descripcion : {descripcion}</p>
                <p className='mb-1 text-xl text-gray-50 '>Resumen : {resumen}</p>
            </div>
        
        </div>
    );

}

export default ViewSolicitudes;