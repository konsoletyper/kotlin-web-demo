var webpack = require('webpack');
var webpackUglifyJsPlugin = require('webpack-uglify-js-plugin');
var path = require("path");

var plugins = [];

if (!process.env.WEB_DEMO_DEVEL) {
    plugins.push(new webpackUglifyJsPlugin({
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
    }));
}

var webpackConfig = {
    entry: {
        index: './index.js'
    },
    output: {
        path: './build/webpack/',
        filename: '[name].js',
        publicPath: '/'
    },
    resolve: {
        extensions: ['', '.js'],
        modulesDirectories: ['node_modules', './build/libs', './build']
    },
    module: {
        loaders: [
            {
                test: /\.css$/,
                loader: 'style-loader!css-loader'
            }
        ]
    },
    plugins: plugins
};

module.exports = webpackConfig;
