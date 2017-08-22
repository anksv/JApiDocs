package io.github.yedaxia.apidocs.parser;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.MarkerAnnotationExpr;
import com.github.javaparser.ast.expr.NormalAnnotationExpr;
import com.github.javaparser.ast.expr.SingleMemberAnnotationExpr;
import io.github.yedaxia.apidocs.Utils;

/**
 * use for spring mvc
 *
 * @author yeguozhong yedaxia.github.com
 */
public class SpringControllerParser extends AbsControllerParser {

    @Override
    protected void afterHandleController(ControllerNode controllerNode, ClassOrInterfaceDeclaration clazz) {
        clazz.getAnnotationByName("RequestMapping").ifPresent( a -> {
            if(a instanceof SingleMemberAnnotationExpr){
                String baseUrl = ((SingleMemberAnnotationExpr)a).getMemberValue().toString();
                controllerNode.setBaseUrl(Utils.removeQuotations(baseUrl));
                return;
            }
            if(a instanceof NormalAnnotationExpr){
                ((NormalAnnotationExpr)a).getPairs().stream()
                        .filter(v -> isUrlPathKey(v.getNameAsString()))
                        .findFirst()
                        .ifPresent(p -> {
                            controllerNode.setBaseUrl(Utils.removeQuotations(p.getValue().toString()));
                        });
            }
        });

    }

    @Override
    protected void afterHandleMethod(RequestNode requestNode, MethodDeclaration md) {
        md.getAnnotations().forEach( an -> {
            String name = an.getNameAsString();

            if( !"GetMapping".equals(name) && !"PostMapping".equals(name) && !"RequestMapping".equals(name)){
                return;
            }

            if("GetMapping".equals(name)){
                requestNode.setMethod(RequestMethod.GET);
            }else if("PostMapping".equals(name)){
                requestNode.setMethod(RequestMethod.POST);
            }

            if(an instanceof SingleMemberAnnotationExpr){
                String url = ((SingleMemberAnnotationExpr)an).getMemberValue().toString();
                requestNode.setUrl(url);
                return;
            }

            if(an instanceof NormalAnnotationExpr){
                ((NormalAnnotationExpr)an).getPairs().forEach(p ->{
                    String key = p.getNameAsString();
                    if(isUrlPathKey(key)){
                        requestNode.setUrl(Utils.removeQuotations(p.getValue().toString()));
                    }

                    if("method".equals(key)){
                        if(p.getValue().toString().contains("POST")){
                            requestNode.setMethod(RequestMethod.POST);
                        }else{
                            requestNode.setMethod(RequestMethod.GET);
                        }
                    }
                });
            }

        });

        md.getParameters().forEach(p -> {
            String paraName  = p.getName().asString();
            ParamNode paramNode = requestNode.getParamNodeByName(paraName);
            if(paramNode != null){
                p.getAnnotationByName("RequestParam").ifPresent(r -> {

                    if(r instanceof MarkerAnnotationExpr){
                        paramNode.setRequired(true);
                        return;
                    }

                    if(r instanceof NormalAnnotationExpr){
                        ((NormalAnnotationExpr) r).getPairs().stream()
                                .filter(name -> name.getNameAsString().equals("required"))
                                .findFirst()
                                .ifPresent(v -> {
                                    paramNode.setRequired(Boolean.valueOf(v.getValue().toString()));
                                });
                    }
                });
            }
        });
    }

    private boolean isUrlPathKey(String name){
        return name.equals("path") || name.equals("value");
    }
}
