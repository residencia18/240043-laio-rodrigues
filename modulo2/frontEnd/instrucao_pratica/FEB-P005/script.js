function expansao(element) {
    var servicosLista = element.nextElementSibling;
    var todosSetores = document.querySelectorAll('.setor');

    // Fechar todos os setores antes de abrir o selecionado
    todosSetores.forEach(function (setor) {
        if (setor !== element.parentElement) {
            var servicosOutroSetor = setor.querySelector('.lista');
            servicosOutroSetor.style.display = 'none';
        }
    });

    // Alternar a visibilidade do setor atual
    servicosLista.style.display === 'none' || servicosLista.style.display === ''
        ? (servicosLista.style.display = 'block')
        : (servicosLista.style.display = 'none');
}