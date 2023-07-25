import React, { useEffect, useState } from 'react';
import crud from '../conexiones/crud';
import { useNavigate, useParams } from 'react-router-dom';
import swal from 'sweetalert';

const ActualizarSolicitud = () => {

  const navigate = useNavigate();

  const { idSolicitud } = useParams();
  //console.log(idSolicitud);

  const [solicitud, setSolicitud] = useState({
    codigo: '',
    descripcion: '',
    resumen: '',
  })


  const cargarSolicitud = async () => {
    const response = await crud.GET(`/api/solicitud/${idSolicitud}`);
    console.log(response);
    //Llenando las cajas
    setSolicitud(response);
  }
  //console.log(solicitud);

  useEffect(() => {
    cargarSolicitud();
  }, []);

  const { codigo, descripcion, resumen } = solicitud;

  const onChange = (e) => {
    setSolicitud({
      ...solicitud,
      [e.target.name]: e.target.value
    })
  }


  const actualizarSolicitud = async () => {
    const data = {
      codigo: solicitud.codigo,
      descripcion: solicitud.descripcion,
      resumen: solicitud.resumen
    }

    const response = await crud.PUT(`/api/solicitud/empleado/solicitudes/${idSolicitud}`, data); // falta id
    console.log(response);
    const mensaje1 = "La Solicitud se actualizo correctamente";
    swal({
      title: 'Información',
      text: mensaje1,
      icon: 'success',
      buttons: {
        confirm: {
          text: 'OK',
          value: true,
          visible: true,
          className: 'btn btn-primary',
          closeModal: true
        }
      }
    });
    navigate("/ver-solicitudes");

  }

  const onSubmit = (e) => {
    e.preventDefault();
    actualizarSolicitud();
  }

  return (
    <>
      <main className='container mx-auto mt-5 md:mt-20 p-5 md:flex md:justify-center'>
        <div className='md:w-2/3 lg:w-2/5'>
          <div className='flex justify-center'>
            <h1 className="inline bg-gradient-to-r from-indigo-200 via-slate-400 to-indigo-200 bg-clip-text font-display text-5xl tracking-tight text-transparent m-10" >
              Actualizar Solicitudes
            </h1>
          </div>


          <form
            className='my-10 bg-gray-700 shadow rounded-lg p-10 '
            onSubmit={onSubmit}
          >
            <div className='my-5'>
              <label className='uppercase text-white block text-xl font-bold' >Codigo</label>
              <input
                type="codigo"
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
              value="Actualizar Solicitud"
              className="bg-blue-500 mb-5 w-full py-3 text-white uppercase font-bold rounded hover:cursor-pointer hover:bg-blue-300  transition-colors"
            />
          </form>
        </div>

      </main>
    </>
  );


}
export default ActualizarSolicitud;