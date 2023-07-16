////package com.example.asses.demo.cors;
////
////import org.springframework.context.annotation.Configuration;
////import org.springframework.web.servlet.config.annotation.CorsRegistry;
////import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
////
////@Configuration
////public class CorsConfig implements WebMvcConfigurer {
////    @Override
////    public void addCorsMappings(CorsRegistry registry) {
////        registry.addMapping("/**")
////                .allowedOrigins("*")
////                .allowedMethods("GET", "POST", "PUT", "DELETE")
////                .allowedHeaders("*");
////    }
////}
//
//
//
//export class HomeComponent {
//
//    holiday:any;
//    constructor(private http:HttpClient,private router:Router, private service:AppService){
//        this.service.getHoliday().subscribe((data:any)=>{this.holiday=data
//        }, (error: { status: number; }) => {
//            if (error instanceof HttpErrorResponse && error.status === 403 || error.status ===401) {
//                localStorage.clear();
//                this.router.navigate(['']);
//            }});}
