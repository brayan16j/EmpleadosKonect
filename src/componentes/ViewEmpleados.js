import React from 'react';
import crud from '../conexiones/crud';
import swal from 'sweetalert'; 
import {  Link, useNavigate, useParams  } from 'react-router-dom';

export const ViewEmpleados = ({empleado}) =>{
    
    const navigate = useNavigate();

    const {idEmpleado} = useParams();
    console.log(idEmpleado);

  const {nombre, salario} = empleado;
  //const {id} = key;
   
   
   const borrarEmpleado = async (idEmpleado) => { //falta id
    console.log(idEmpleado);
    swal({
      title: " Estas Seguro de eliminar el empleado?",
      text: "Una vez eliminado no se podra recuperar",
      icon: "warning",
      buttons: true,
      dangerMode: true,
    })
    .then((willDelete) => {
      if (willDelete) {
          const response = crud.DELETE(`/api/${idEmpleado}`);
          const mensaje = response;
          if(response){
            swal("Tu Empleado a sido eliminado correctamente ", {
              icon: "success",
            });
          }
          window.location.reload();
      } else {
        swal("Se cancelo la accion");
      }
    });
   }
   
   
    return(
        <div
            className='border-r p-5 flex justify-between items-center'
        >
            <div className='flex flex-col items-start'>
                <p className='mb-1 text-xl text-gray-50'>Nombre : {nombre}</p>
                <p className='mb-1 text-xl text-gray-50 '>Salario : {salario}</p>
            </div>

            <div className='flex flex-col lg:flex-row gap-2'>
         
                <button
                          className="bg-red-600 px-4 py-3 text-white uppercase font-bold text-sm rounded-lg"
                          onClick={() => borrarEmpleado(empleado.id)} // falta id
                      >Eliminar</button>
                <Link 
                    to={`/crear-solicitud/${(empleado.id)}`}
                    className="block text-center my-5 text-blue-500  uppercase text-sm"
                >Crear Solicitud</Link>
            </div>
        
        </div>
    );

}

export default ViewEmpleados;