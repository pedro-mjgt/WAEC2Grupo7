$(document).on("click", "#btnagregar", function(){
    $("#txtnomcurso").val("");
    $("#txtresumen").val("");
    $("#dtfecreg").val("");
    $("#hddcurcod").val("0");
    listarCboDocente(0);
    $("#modalcurso").modal("show");
});

$(document).on("click", ".btnactualizar", function(){
    $("#txtnomcurso").val($(this).attr("data-curnom"));
    $("#txtresumen").val($(this).attr("data-resumen"));
    $("#dtfecreg").val($(this).attr("data-fecreg"));
    $("#hddcurcod").val($(this).attr("data-curcod"));
    $("#cbodocente").empty();
    listarCboDocente($(this).attr("data-curdoc"));
    $("#modalcurso").modal("show");
})

$(document).on("click", "#btnguardar", function(){
    $.ajax({
        type: "POST",
        url: "/curso/register",
        contentType: "application/json",
        data: JSON.stringify({
            idcurso: $("#hddcurcod").val(),
            nomcurso: $("#txtnomcurso").val(),
            resumen: $("#txtresumen").val(),
            fecharegistro: $("#dtfecreg").val(),
            iddocente: $("#cbodocente").val()
        }),
        success: function(resultado){
            if(resultado.respuesta){
                listarCursos()
            }
            alert(resultado.mensaje);
        }
    });
    $("#modalcurso").modal("hide");
});

function listarCursos(){
    $.ajax({
        type: "GET",
        url: "/curso/list",
        dataType: "json",
        success: function(resultado){
            $("#tblcurso > tbody").html("");
            $.each(resultado, function(index, value){
                $("#tblcurso > tbody").append(`<tr>`+
                `<td>${value.idcurso}</td>`+
                `<td>${value.nomcurso}</td>`+
                `<td>${value.resumen}</td>`+
                `<td>${value.fecharegistro}</td>`+
                `<td>${value.docente.nomdocente + ' ' + value.docente.apedocente}</td>`+
                `<td><button type='button' class='btn btn-warning btnactualizar' `+
                    `data-curcod="${value.idcurso}" `+
                    `data-curnom="${value.nomcurso}" `+
                    `data-resumen="${value.resumen}" `+
                    `data-fecreg="${value.fecharegistro}" `+
                    `data-curdoc="${value.docente.iddocente}">Actualizar`+
                `</button>`+
                `<form th:action="@{/curso/eliminar}" th:method="post" style="display: inline;">`+
                                            `<input type="hidden" th:name="id" th:value="${value.idcurso}">`+
                                            `<button type='submit' class='btn btn-danger btneliminar'>Eliminar</button>`+
                                        `</form>`+
                `</td>`+
                `</tr>`);
            });
        }
    });
}

function listarCboDocente(idDocente){
    $.ajax({
        type: "GET",
        url: "/docente/get",
        dataType: "json",
        success: function(resultado){
            $.each(resultado, function(index, value){
                $("#cbodocente").append(
                    `<option value="${value.iddocente}">${value.nomdocente + ' ' + value.apedocente}</option>`
                )
            });
            if(idDocente > 0){
                $("#cbodocente").val(idDocente);
            }
        }
    })
}