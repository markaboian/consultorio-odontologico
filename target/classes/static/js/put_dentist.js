window.addEventListener('load', function () {

    //Buscamos y obtenemos el formulario donde estan
    //los datos que el usuario pudo haber modificado del odontologo
    const formulario = document.querySelector('#update_dentist_form');
    formulario.addEventListener('submit', function (event) {
        event.preventDefault();
        let studentId = document.querySelector('#dentist_id').value;

        //creamos un JSON que tendrá los datos del odonotologo
        //a diferencia de un odontologo nuevo en este caso enviamos el id
        //para poder identificarlo y modificarlo para no cargarlo como nuevo
        const formData = {
            id: document.querySelector('#dentist_id').value,
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            matricula: document.querySelector('#matricula').value
        };

        //invocamos utilizando la función fetch la API odontologos con el método PUT
        //que modificará al estudiante que enviaremos en formato JSON
        const url = '/odontologos/modify';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
                "Access-Control-Allow-Origin" : "*",
                "Access-Control-Allow-Credentials" : true
            },
            body: JSON.stringify(formData)
        }
          fetch(url,settings)
          .then(response => response.text())

    })
 })

    //Es la funcion que se invoca cuando se hace click sobre el id de un odontologo del listado
    //se encarga de llenar el formulario con los datos del odontologo
    //que se desea modificar
    function findBy(id) {
          const url = '/odontologos/get'+"/"+id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let dentist = data;
              document.querySelector('#dentist_id').value = dentist.id;
              document.querySelector('#nombre').value = dentist.nombre;
              document.querySelector('#apellido').value = dentist.apellido;
              document.querySelector('#matricula').value = dentist.matricula;

            //el formulario por default esta oculto y al editar se habilita
              document.querySelector('#div_dentist_updating').style.display = "block";
          }).catch(error => {
              alert("Error: " + error);
          })
      }