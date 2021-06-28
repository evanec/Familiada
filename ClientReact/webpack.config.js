const ReactRefreshPlugin = require('@pmmmwh/react-refresh-webpack-plugin');
const webpack = require('webpack');
module.exports = {
    output: {
        filename: 'react-app.js'
    },
    entry: {
        main: './src/main/webapp/javascript/Main.jsx',
    },
    mode:'development',
    devtool: 'inline-cheap-module-source-map',
    devServer: {
        contentBase: './src/main/resources/static/dist',
    },
    module: {
        rules: [{
            test: /\.(js|jsx)$/,
            exclude: /node_modules/,
            loader: "babel-loader",
            options: {
                presets: ['@babel/preset-env', '@babel/preset-react'],
                plugins: [require.resolve('react-refresh/babel')].filter(Boolean),
            }
        }, {
                     test: /\.(css|min.css)$/,
                     use: ['style-loader', 'css-loader']
                 }]
    },
    resolve: {
        extensions: ['.js', '.jsx']
    },
    plugins: [
        new webpack.HotModuleReplacementPlugin(),
        new ReactRefreshPlugin(),
    ].filter(Boolean)
};
