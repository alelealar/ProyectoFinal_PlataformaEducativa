document.addEventListener('DOMContentLoaded', () => {
    const darkModeToggle = document.getElementById('dark-mode-toggle');
    const body = document.body;

    // 1. Verificar si ya existía una preferencia guardada en localStorage
    const savedTheme = localStorage.getItem('theme');

    if (savedTheme === 'dark') {
        body.classList.add('dark-mode');
        if (darkModeToggle) {
            darkModeToggle.checked = true; // Marca el switch si está activado
        }
    }

    // 2. Escuchar cuando el usuario presiona el switch
    if (darkModeToggle) {
        darkModeToggle.addEventListener('change', () => {
            if (darkModeToggle.checked) {
                body.classList.add('dark-mode');
                localStorage.setItem('theme', 'dark');
            } else {
                body.classList.remove('dark-mode');
                localStorage.setItem('theme', 'light');
            }
        });
    }
});

document.addEventListener('DOMContentLoaded', () => {
    const btnManual = document.getElementById('btn-manual');
    const btnCsv = document.getElementById('btn-csv');
    const vistaManual = document.getElementById('vista-manual');
    const vistaCsv = document.getElementById('vista-csv');

    if (btnManual && btnCsv && vistaManual && vistaCsv) {
        // Clic en pestaña "Manual"
        btnManual.addEventListener('click', () => {
            btnManual.classList.add('is-active');
            btnCsv.classList.remove('is-active');

            vistaManual.classList.remove('is-hidden');
            vistaCsv.classList.add('is-hidden');
        });

        // Clic en pestaña "Carga Masiva CSV"
        btnCsv.addEventListener('click', () => {
            btnCsv.classList.add('is-active');
            btnManual.classList.remove('is-active');

            vistaCsv.classList.remove('is-hidden');
            vistaManual.classList.add('is-hidden');
        });
    }
});