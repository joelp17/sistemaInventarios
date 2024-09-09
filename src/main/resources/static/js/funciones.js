function confirmarEliminacion(idproducto) {
  Swal.fire({
    title: "¿Seguro de eliminar el producto?",
    text: "",
    icon: "warning",
    showCancelButton: true,
  }).then((result) => {
    if (result.isConfirmed) {
      $.ajax({
        url: "/eliminarProducto",
        type: "POST",
        data: {
          id: idproducto,
        },
        dataType: "json",
        success: function (data) {
          if (data.success) {
            Swal.fire(
              "Eliminado!",
              "El producto ha sido eliminado.",
              "success"
            ).then(() => {
              location.reload();
            });
          } else {
            Swal.fire("Error!", "No se pudo eliminar el producto.", "error");
          }
        },
        error: function () {
          Swal.fire(
            "Error!",
            "Ocurrió un error al intentar eliminar el producto.",
            "error"
          );
        },
      });
    }
  });
}

function agregarProducto() {
  
  var nombre = $("#nombre").val().trim();
  var codigo = $("#codigo").val().trim();
  var descripcion = $("#descripcion").val().trim();
  var cantidad_stock = $("#cantidad_stock").val().trim();
  var precio = $("#precio").val().trim();
  var ubicacionId = $("#ubicacionId").val().trim();
 
  if (!nombre || !codigo || !descripcion || !cantidad_stock || !precio || !ubicacionId) {
    Swal.fire({
      title: "Error!",
      text: "Todos los campos son obligatorios.",
      icon: "error",
      target: document.getElementById("formAgregarProducto"),
    });
    return;  
  }

  var formData = $("#formAgregarProducto").serialize() + "&tipo_movimiento=1";
  $.ajax({
    url: "/productos",
    method: "POST",
    dataType: "json",
    data: formData,
    success: function (response) {
      console.log(response.success);
      if (response.success) {
        Swal.fire({
          title: "¡Éxito!",
          text: "El producto ha sido agregado correctamente",
          icon: "success",
          target: document.getElementById("formAgregarProducto"),
        }).then(() => {
          location.reload();
        });
      } else {
        Swal.fire({
          title: "Error!",
          text: response.message,
          icon: "error",
          target: document.getElementById("formAgregarProducto"),
        });
      }

      $.fancybox.close();
    },
    error: function () {
      Swal.fire({
        title: "Error!",
        text: "Ocurrió un error al intentar agregar el producto.",
        icon: "error",
        target: document.getElementById("formAgregarProducto"),
      });
    },
  });
}
