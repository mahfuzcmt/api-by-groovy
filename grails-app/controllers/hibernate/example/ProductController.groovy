package hibernate.example

import grails.converters.JSON
import grails.rest.Resource
import grails.rest.RestfulController

@Resource(uri='/api/orders', formats=['json', 'xml'])
class ProductController {
   def test(){
       return 10;
   }
}