package com.jamesfchen.network.json;

import java.net.URL;

/**
 * Copyright ® $ 2017
 * All right reserved.
 *
 * @author: jamesfchen
 * @since: Aug/13/2019  Tue
 */
public class GithubApiForGson {

    /**
     * current_user_url : https://api.github.com/user
     * current_user_authorizations_html_url : https://github.com/settings/connections/applications{/client_id}
     * authorizations_url : https://api.github.com/authorizations
     * code_search_url : https://api.github.com/search/code?q={query}{&page,per_page,sort,order}
     * commit_search_url : https://api.github.com/search/commits?q={query}{&page,per_page,sort,order}
     * emails_url : https://api.github.com/user/emails
     * emojis_url : https://api.github.com/emojis
     * events_url : https://api.github.com/events
     * feeds_url : https://api.github.com/feeds
     * followers_url : https://api.github.com/user/followers
     * following_url : https://api.github.com/user/following{/target}
     * gists_url : https://api.github.com/gists{/gist_id}
     * hub_url : https://api.github.com/hub
     * issue_search_url : https://api.github.com/search/issues?q={query}{&page,per_page,sort,order}
     * issues_url : https://api.github.com/issues
     * keys_url : https://api.github.com/user/keys
     * notifications_url : https://api.github.com/notifications
     * organization_repositories_url : https://api.github.com/orgs/{org}/repos{?type,page,per_page,sort}
     * organization_url : https://api.github.com/orgs/{org}
     * public_gists_url : https://api.github.com/gists/public
     * rate_limit_url : https://api.github.com/rate_limit
     * repository_url : https://api.github.com/repos/{owner}/{repo}
     * repository_search_url : https://api.github.com/search/repositories?q={query}{&page,per_page,sort,order}
     * current_user_repositories_url : https://api.github.com/user/repos{?type,page,per_page,sort}
     * starred_url : https://api.github.com/user/starred{/owner}{/repo}
     * starred_gists_url : https://api.github.com/gists/starred
     * team_url : https://api.github.com/teams
     * user_url : https://api.github.com/users/{user}
     * user_organizations_url : https://api.github.com/user/orgs
     * user_repositories_url : https://api.github.com/users/{user}/repos{?type,page,per_page,sort}
     * user_search_url : https://api.github.com/search/users?q={query}{&page,per_page,sort,order}
     */

    public URL current_user_url;
    public URL current_user_authorizations_html_url;
    public URL authorizations_url;
    public URL code_search_url;
    public URL commit_search_url;
    public URL emails_url;
    public URL emojis_url;
    public URL events_url;
    public URL feeds_url;
    public URL followers_url;
    public URL following_url;
    public URL gists_url;
    public URL hub_url;
    public URL issue_search_url;
    public URL issues_url;
    public URL keys_url;
    public URL notifications_url;
    public URL organization_repositories_url;
    public URL organization_url;
    public URL public_gists_url;
    public URL rate_limit_url;
    public URL repository_url;
    public URL repository_search_url;
    public URL current_user_repositories_url;
    public URL starred_url;
    public URL starred_gists_url;
    public URL team_url;
    public URL user_url;
    public URL user_organizations_url;
    public URL user_repositories_url;
    public URL user_search_url;
    public String text;
    public TitleBar titlebar;
}
