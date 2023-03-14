import React from 'react';
import crud from '../conexiones/crud';
import swal from 'sweetalert';
import { Link, useParams } from 'react-router-dom';

export const ViewSolicitudes = ({ solicitud, nombreEmpleado }) => {
    //console.log(solicitud);
    //console.log(nombreEmpleado);
    //const navigate = useNavigate();

    const {idSolicitud} = useParams();
    //console.log(idSolicitud);

    const { id, codigo, descripcion, resumen } = solicitud;

    //const {id} = key;

    const borrarSolicitud = async (idSolicitud) => { //falta id
        console.log(idSolicitud);
        swal({
          title: " Estas Seguro de eliminar la Solicitud?",
          text: "Una vez eliminada no se podra recuperar",
          icon: "warning",
          buttons: true,
          dangerMode: true,
        })
          .then((willDelete) => {
            if (willDelete) {
              const response = crud.DELETE(`/api/solicitud/${idSolicitud}`);
              const mensaje = response;
              if (response) {
                swal("Tu Solicitud a sido eliminada correctamente ", {
                  icon: "success",
                });
              }
              window.location.reload();
            } else {
              swal("Se cancelo la accion");
            }
          });
      }


    return (
        <div
            className='border-r p-5 flex justify-between items-center'
        >
            <div className='flex flex-col items-start'>
                <p className='mb-1 text-xl text-gray-50'>Nombre : {nombreEmpleado}</p>
                <p className='mb-1 text-xl text-gray-50'>Solicitud : {id}</p>
                <p className='mb-1 text-xl text-gray-50'>Codigo : {codigo}</p>
                <p className='mb-1 text-xl text-gray-50'>Descripcion : {descripcion}</p>
                <p className='mb-1 text-xl text-gray-50'>Resumen : {resumen}</p>
            </div>

            <div className='flex flex-col lg:flex-row gap-2'>
            <Link 
                to={`/Actualizar-solicitudes/${(solicitud.id)}`}
                className='bg-blue-500 w-full p-4 text-white uppercase font-bold mt-5 text-center rounded-lg'
                >Actualizar</Link>

                <button
                    className="bg-red-600 px-4 py-3 text-white uppercase font-bold mt-5 text-sm rounded-lg"
                    onClick={() => borrarSolicitud(solicitud.id)} // falta id
                >Eliminar</button>
            </div>

        </div>
    );

}

export default ViewSolicitudes;