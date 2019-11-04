package hello;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("repos")
public class IssueController {

    // DELETE /repos/:owner/:repo/issues/:issue_number/lock
    @DeleteMapping("/{owner}/{repo}/issues/{issue_number}/lock")
    public String unlock(
            @PathVariable("owner") String owner,
            @PathVariable("repo")String repo,
            @PathVariable("issue_number")String issue_number
            ){
        // 把当前请求路径重的参数 绑定到当前变量中去
        // @PathVariable()
        System.out.println(owner);
        System.out.println(repo);
        System.out.println(issue_number);

        return "owner:" + owner + ",repo:" + repo + ",issue_number:" + issue_number;
    }

    /*
    POST /repos/:owner/:repo/issues
    设置 header
        content-type:application/json
    请求体里 raw 里放置
    {
      "title": "Found a bug",
      "body": "I'm having a problem with this.",
      "assignees": [
        "octocat"
      ],
      "milestone": 1,
      "labels": [
        "bug"
      ]
    }
     */
    @PostMapping("/{owner}/{repo}/issues")
    public String create(
            @PathVariable("owner") String owner,
            @PathVariable("repo")String repo,
            @RequestBody MyParam object
    ){
        System.out.println(object);
        object.getTitle();
        object.getLabels().get(0);
        return "owner:" + owner + ",repo:" + repo + ",request body:" + object;
    }

    // localhost:8080/repos/demo
    // form-data 一般用于参数少的时候
    @PostMapping("/demo")
    public void postform(
            @RequestParam String name,
            @RequestParam Integer age
    ){
        System.out.println(name);
        System.out.println(age);
    }


    // 通过 HttpServletResponse 设置响应的内容
    @RequestMapping("search")
    public void search(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.getWriter().write("haha");
    }

    // 通过 @ResponseBody 设置响应为 json
    @RequestMapping("search2")
    @ResponseBody
    public Object search2(){
        Map<String,Object> result = new HashMap<>();
        result.put("name","aaa");
        result.put("age",18);
        return result;
    }


}
