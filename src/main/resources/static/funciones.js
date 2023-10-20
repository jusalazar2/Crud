function eliminar(id,name,apellido) {
	swal({
		title: "¿ Estas seguro ?",
		text: "¡Una vez eliminado, no podrás recuperar a "+ name +"  " +apellido+" !",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then((OK) => {
			if (OK) {
				$.ajax({
					url:"/eliminar/"+id,
					success: function(res){
						console.log(res);
					}
				})
				swal("¡Tu registro ha sido eliminado!", {
					icon: "success",
				}).then((ok)=>{
					if(ok){
						location.href="/listar"
					}
				});
			} else {
				swal("¡Tu registro está a salvo!", {
					icon: "info",
				});
			}
		});
}


function eliminarr(id,name,apellido) {
	swal({
		title: "¿ Estas seguro ?",
		text: "¡Una vez eliminado, no podrás recuperar a "+ name +"  !",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then((OK) => {
			if (OK) {
				$.ajax({
					url:"/eliminarLogin/"+id,
					success: function(res){
						console.log(res);
					}
				})
				swal("¡Tu registro ha sido eliminado!", {
					icon: "success",
				}).then((ok)=>{
					if(ok){
						location.href="/listarUsuarios"
					}
				});
			} else {
				swal("¡Tu registro está a salvo!", {
					icon: "info",
				});
			}
		});
}