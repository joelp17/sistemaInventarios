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
