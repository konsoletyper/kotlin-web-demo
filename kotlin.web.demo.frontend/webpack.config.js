var webpack = require('webpack');
var webpackUglifyJsPlugin = require('webpack-uglify-js-plugin');
var path = require("path");

var webpackConfig = {
    entry: {
        index: './index.js'
    },
    output: {
        path: './static',
        filename: '[name].js',
        publicPath: '/'
    },
    resolve: {
        extensions: ['', '.js'],
        modulesDirectories: ['node_modules', './build/libs']
    },
    module: {
        loaders: [
            {
                test: /\.css$/,
                loader: 'style-loader!css-loader'
            }
        ]
    },
    plugins: [
        new webpackUglifyJsPlugin({
            cacheFolder: path.resolve(__dirname, 'public/cached_uglify/'),
            debug: false,
            minimize: true,
            sourceMap: false,
            output: {
                comments: false
            },
            compressor: {
                warnings: false
            }
        })
    ]
};

module.exports = webpackConfig;
