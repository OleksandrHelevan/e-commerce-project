const gulp = require('gulp');
const sass = require('gulp-sass')(require('sass'));

// Шляхи
const scssMainFile = './scss/main.scss';
const scssWatchFiles = './scss/**/*.scss';
const cssDest = './css';

function compileScss() {
    return gulp.src(scssMainFile)
        .pipe(sass().on('error', sass.logError))
        .pipe(gulp.dest(cssDest));
}

function watchScss() {
    gulp.watch(scssWatchFiles, compileScss);
}

exports.default = gulp.series(compileScss, watchScss);
